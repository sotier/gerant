package com.fireflyi.gn.gerant.client.core;

import com.fireflyi.gn.gerant.domain.protobuf.GerantReqProtobuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

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

}
