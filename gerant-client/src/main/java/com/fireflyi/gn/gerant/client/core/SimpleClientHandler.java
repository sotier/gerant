package com.fireflyi.gn.gerant.client.core;

import com.fireflyi.gn.gerant.common.service.GerantServerInfoService;
import com.fireflyi.gn.gerant.domain.protobuf.GerantReqProtobuf;
import com.google.inject.Inject;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/20
 * DESC TODO
 */
@ChannelHandler.Sharable
public class SimpleClientHandler extends SimpleChannelInboundHandler<GerantReqProtobuf.GerantReqProtocol> {

    @Inject
    private static GerantSocketclient gerantSocketclient;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GerantReqProtobuf.GerantReqProtocol msg) throws Exception {
        System.out.println(msg.toString());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("掉线了...");
    }


}
