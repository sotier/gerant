package com.fireflyi.gerant.mcenter.core;

import com.fireflyi.gerant.rpclient.protobuf.Greq;

import static java.lang.Thread.sleep;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/26
 * DESC TODO
 */
public abstract class McenterHandlerAdapter implements McHandler {

    String cmdId;

    @Override
    public abstract void doHandler(Greq var1);

    @Override
    public void progress(Greq var1){
        if(!var1.getCmdId().equals(getCmdId())){
            return ;
        }
        doHandler(var1);
    }

    @Override
    public abstract String getCmdId();

}
