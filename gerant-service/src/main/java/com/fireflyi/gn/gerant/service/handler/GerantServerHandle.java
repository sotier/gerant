package com.fireflyi.gn.gerant.service.handler;

import com.fireflyi.gn.gerant.common.service.GerantServerInfoService;
import com.fireflyi.gn.gerant.common.util.ProToBufBuild;
import com.fireflyi.gn.gerant.domain.protobuf.GerantReqProtobuf;
import com.google.inject.Inject;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/18
 * DESC TODO
 */

@ChannelHandler.Sharable
public class GerantServerHandle extends SimpleChannelInboundHandler<GerantReqProtobuf.GerantReqProtocol> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, GerantReqProtobuf.GerantReqProtocol msg) throws Exception {
        System.out.println("收到"+ msg.getReqMsg()+",Type->"+msg.getType().getNumber());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("有新链接");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("连接断开");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //异常时断开连接
        cause.printStackTrace() ;
        ctx.close() ;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt ;
            //客户端心跳
            if (idleStateEvent.state() == IdleState.WRITER_IDLE){
                GerantReqProtobuf.GerantReqProtocol.Builder heartBeat = ProToBufBuild.Pinger();
                ctx.writeAndFlush(heartBeat).addListeners((ChannelFutureListener) future -> {
                    if (!future.isSuccess()) {
                        future.channel().close();
                    }
                }) ;
            }
        }
        super.userEventTriggered(ctx, evt);
    }

}
