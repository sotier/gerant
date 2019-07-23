package com.fireflyi.gn.gerant.domain.protobuf;


import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/19
 * DESC TODO
 */
public class PtbTest {

    /**
     * 编码GerantReqProtobuf.GerantReqProtocol对象
     * @param req
     * @return
     */
    private static byte[] encode(GerantReqProtobuf.GerantReqProtocol req) {
        return req.toByteArray();
    }

    /**
     * 解码GerantReqProtobuf.GerantReqProtocol对象
     * @param body
     * @return
     * @throws InvalidProtocolBufferException
     */
    private static GerantReqProtobuf.GerantReqProtocol decode(byte[] body) throws InvalidProtocolBufferException {
        return GerantReqProtobuf.GerantReqProtocol.parseFrom(body);
    }

    /**
     * 创建GerantReqProtobuf.GerantReqProtocol对象
     * @return
     */
    private static GerantReqProtobuf.GerantReqProtocol crete(){
        GerantReqProtobuf.GerantReqProtocol.Builder builder = GerantReqProtobuf.GerantReqProtocol.newBuilder();
        builder.setType(GerantReqProtobuf.ChatType.CHAT_TYPE_PUBLIC);
        builder.setReqMsg("hello com.fireflyi.gn.gerant.domain.protobuf");
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        GerantReqProtobuf.GerantReqProtocol ptb = crete();
        GerantReqProtobuf.GerantReqProtocol ptb2 = decode(encode(ptb));
        System.out.println("ptb对象->" + ptb.toString());
        System.out.println("编码在解码ptb对象->" + ptb2);
        System.out.println(ptb.equals(ptb2));
        System.out.println(ptb.hashCode());
        System.out.println(ptb2.hashCode());
    }

}
