package com.gerant.zk;

import com.gerant.zk.service.ZkService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/7
 * DESC 分布式长连接服务节点节点注册
 */
@Singleton
public class ServerRegistryZK implements Runnable {

    @Inject
    private ZkService zkService;

    @Inject
    @Named("zk.rootNode")
    private String rootNode;

    @Inject
    @Named("base.server.port")
    private String serverPort;

    @Override
    public void run() {
        //xxxxxxx
        String localNode = "127.0.0.1:" + serverPort;
        zkService.addLocalNode(rootNode + "/" + localNode, localNode);
        zkService.zkSubscribeEvent(rootNode);
    }
}