package com.gerant.zk.service;

import com.fireflyi.gn.gerant.domain.ServerNodeInfo;
import com.gerant.zk.service.impl.ZkServiceImpl;
import com.google.inject.ImplementedBy;

import java.util.List;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/6
 * DESC TODO
 */
@ImplementedBy(ZkServiceImpl.class)
public interface ZkService {

    void initZkc();

    /**
     * 检查root节点是否存在，否则创建
     */
    void checkRootNode();

    /**
     * 添加一个节点
     */
    void addNode(String var);

    /**
     * 将本机服务节点加入
     */
    void addLocalNode(String path, String value);

    /**
     * 客户端监听节点
     * @param var
     */
    void zkSubscribeEvent(String var);

    /**
     * 获取一个服务节点
     * @return
     */
    ServerNodeInfo getOneServer();

    /**
     * 获取所有节点
     * @return
     */
    List<ServerNodeInfo> getAll();



}
