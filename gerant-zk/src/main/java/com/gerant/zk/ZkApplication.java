package com.gerant.zk;

import com.gerant.zk.service.ZkService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/6
 * DESC TODO
 */
@Singleton
public class ZkApplication {

    @Inject
    ServerRegistryZK serverRegistryZK;

    @Inject
    public void run(){
        Thread t = new Thread(serverRegistryZK);
        t.start();
    }

}
