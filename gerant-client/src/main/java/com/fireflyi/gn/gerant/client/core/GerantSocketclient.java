package com.fireflyi.gn.gerant.client.core;

import com.fireflyi.gn.gerant.client.handler.ClientIdleStateHandler;
import com.fireflyi.gn.gerant.core.GerantServerInfoService;
import com.fireflyi.gn.gerant.domain.protobuf.GerantReqProtobuf;
import com.google.inject.Inject;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * 客户端启动类
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/20
 * DESC TODO
 */
public class GerantSocketclient {

    @Inject
    private GerantServerInfoService gerantServerInfoService;

    @Inject
    public void connect(){
        //netty通过ServerBootstrap启动服务端
        Bootstrap client = new Bootstrap();
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            client.group(group);
            client.channel(NioSocketChannel.class);
            client.handler(new ChannelInitializer<Channel>() {  //通道是NioSocketChannel
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    //Protobuf编解码器加在SimpleClientHandler的上面
                    ch.pipeline()
                            .addLast(new ProtobufVarint32FrameDecoder())
                            .addLast(new ProtobufDecoder(GerantReqProtobuf.GerantReqProtocol.getDefaultInstance()))
                            .addLast(new ProtobufVarint32LengthFieldPrepender())
                            .addLast(new ProtobufEncoder())
                            .addLast(new IdleStateHandler(0, 15, 0, TimeUnit.SECONDS))
                            .addLast(new ClientIdleStateHandler())
                            .addLast(new SimpleClientHandler());
                }
            });

            //连接服务器
            ChannelFuture future = client.connect(gerantServerInfoService.getServerInfo().getIp(), 6288).sync();
            if(future.isSuccess()){
                System.out.println("客户端链接成功");
            }else{
                System.out.println("启动失败重连");
                future.channel().eventLoop().schedule(new Runnable() {
                    @Override
                    public void run() {
                        connect();
                    }
                },1,TimeUnit.SECONDS);
            }

            //发送数据
            GerantReqProtobuf.GerantReqProtocol.Builder builder = GerantReqProtobuf.GerantReqProtocol.newBuilder();
            builder.setType(GerantReqProtobuf.ChatType.CHAT_TYPE_PUBLIC);
            builder.setReqMsg("cliend,send protobuf消息");
            for(int i=0;i<2;i++) {
                ChannelFuture futures = future.channel().writeAndFlush(builder.build());
                futures.addListener((ChannelFutureListener) channelFuture ->
                        System.out.println("客户端手动发消息成功"));
            }

            //当通道关闭了，就继续往下走
            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //优雅的退出程序
            group.shutdownGracefully();
        }
    }

}
