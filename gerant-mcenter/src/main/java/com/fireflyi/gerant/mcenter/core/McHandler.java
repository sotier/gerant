package com.fireflyi.gerant.mcenter.core;

import com.fireflyi.gerant.rpclient.protobuf.Greq;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/26
 * DESC TODO
 */
public interface McHandler {

    void doHandler(Greq var1) throws Exception;

    void progress(Greq var1) throws Exception;

    String getCmdId();

}
