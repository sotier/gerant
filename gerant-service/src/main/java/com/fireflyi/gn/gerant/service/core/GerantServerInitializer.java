package com.fireflyi.gn.gerant.service.core;

import com.fireflyi.gn.gerant.service.handle.GerantServerHandle;
import com.fireflyi.gn.gerant.domain.protobuf.GerantReqProtobuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * Created by fireflyi on 2019/7/18.
 * DESC TODO
 */
public class GerantServerInitializer extends ChannelInitializer<Channel> {

    private GerantServerHandle gerantServerHandle = new GerantServerHandle();

    @Override
    protected void initChannel(Channel channel) throws Exception {
        channel.pipeline()
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(GerantReqProtobuf.GerantReqProtocol.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                .addLast(gerantServerHandle);
    }
}
