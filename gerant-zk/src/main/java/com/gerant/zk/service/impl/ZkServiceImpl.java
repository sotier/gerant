package com.gerant.zk.service.impl;

import com.alibaba.fastjson.JSON;
import com.fireflyi.gn.gerant.domain.ServerNodeInfo;
import com.gerant.zk.service.ZkService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/6
 * DESC zk操作实现类
 */
@Singleton
public class ZkServiceImpl implements ZkService {

    private static final Logger logger = LoggerFactory.getLogger(ZkServiceImpl.class);

    private ZkClient zkc;

    @Inject
    @Named("base.server.port")
    private String serverPort;

    @Inject
    @Named("zk.rootNode")
    private String rootNode;

    @Inject
    @Named("zk.server.port")
    private String zkPort;


    @Inject
    @Override
    public void initZkc() {
        String localIp;
        try {
            localIp = InetAddress.getLocalHost().getHostAddress();
            logger.info("localIp->{},serverPort->{}",localIp,zkPort);
            //zkc = new ZkClient(localIp+":"+zkPort);
            zkc = new ZkClient("127.0.0.1:"+zkPort);
            //检查root节点
            checkRootNode();

        } catch (Exception e) {
            logger.error("e->{}",e.getMessage());
        }

    }

    @Override
    public void checkRootNode() {
        boolean ex = zkc.exists(rootNode);
        if(!ex){
            addNode(rootNode);
        }
    }

    @Override
    public void addNode(String var) {
        zkc.createPersistent(var);
    }

    @Override
    public void addLocalNode() {

    }

    @Override
    public void zkSubscribeEvent(String var) {
        zkc.subscribeChildChanges(rootNode, new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                logger.info("清除/更新本地缓存 parentPath->{},currentChilds->{}", parentPath,currentChilds.toString());
            }
        });
    }

    @Override
    public ServerNodeInfo getOneServer() {
        return null;
    }

    @Override
    public List<ServerNodeInfo> getAll() {
        List<String> cs = zkc.getChildren(rootNode);
        logger.info(JSON.toJSONString(cs));
        return null;
    }
}
