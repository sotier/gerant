package com.fireflyi.gn.gerant.common.util;

import com.fireflyi.gn.gerant.domain.protobuf.GerantReqProtobuf;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/23
 * DESC TODO
 */
public class ProToBufBuild {

    /**
     * 获取ptb实例
     * @return
     */
    public static final GerantReqProtobuf.GerantReqProtocol ProToBufInstance(){
        return GerantReqProtobuf.GerantReqProtocol.getDefaultInstance();
    }

    /**
     * 获取ptb Builder
     * @return
     */
    public static final GerantReqProtobuf.GerantReqProtocol.Builder ProToBufBuild(){
        return GerantReqProtobuf.GerantReqProtocol.newBuilder();
    }

    /**
     * 构造ptb pinger
     * @return
     */
    public static final GerantReqProtobuf.GerantReqProtocol.Builder Pinger(){
        GerantReqProtobuf.GerantReqProtocol.Builder heartBeat = ProToBufBuild.ProToBufBuild();
        heartBeat.setType(GerantReqProtobuf.ChatType.CHAT_TYPE_PRIVATE);
        heartBeat.setReqMsg("PING");
        return heartBeat;
    }

}
