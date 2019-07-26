package com.fireflyi.gerant.mcenter.core.impl;

import com.fireflyi.gerant.mcenter.core.McenterHandlerAdapter;
import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gn.gerant.domain.enumentity.CmdIdEnum;
import com.google.inject.Singleton;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/26
 * DESC TODO
 */
@Singleton
public class UsertuService extends McenterHandlerAdapter {

    private static String cmdId = CmdIdEnum.USER_TO_USER.cmdId;

    @Override
    public void doHandler(Greq var1) {
        System.out.println("UsertuService->"+var1.getCmdId());
    }

    @Override
    public String getCmdId() {
        return cmdId;
    }


}
