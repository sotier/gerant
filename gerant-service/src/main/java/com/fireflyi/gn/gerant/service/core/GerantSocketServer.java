package com.fireflyi.gn.gerant.service.core;

import com.fireflyi.gn.gerant.core.cache.RedisClient;
import com.gerant.zk.ServerRegistryZK;
import com.gerant.zk.ZkApplication;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/20
 * DESC TODO
 */
public class GerantSocketServer {

    @Inject
    ServerRegistryZK serverRegistryZK;

    @Inject
    @Named("base.server.port")
    private Integer PORT;

    @Inject
    public void run(){

        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(boosGroup, workGroup);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new GerantServerInitializer());

            Channel ch = b.bind(PORT).sync().channel();

            //注册zk
            Thread t = new Thread(serverRegistryZK);
            t.start();

            //
            ch.closeFuture().sync();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //优雅的退出程序
            boosGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

}
