package com.fireflyi.gn.gerant.client.core;

import com.fireflyi.gn.gerant.common.util.ProToBufBuild;
import com.fireflyi.gn.gerant.domain.protobuf.GerantReqProtobuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/20
 * DESC TODO
 */
@ChannelHandler.Sharable
public class SimpleClientHandler extends SimpleChannelInboundHandler<GerantReqProtobuf.GerantReqProtocol> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GerantReqProtobuf.GerantReqProtocol msg) throws Exception {
        System.out.println(msg.toString());
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
