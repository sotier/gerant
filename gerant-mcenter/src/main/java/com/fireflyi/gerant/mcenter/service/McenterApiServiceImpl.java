package com.fireflyi.gerant.mcenter.service;

import com.fireflyi.gerant.mcenter.McenterLaunches;
import com.fireflyi.gerant.mcenter.core.McenterHandlerAdapter;
import com.fireflyi.gerant.mcenter.core.impl.UsertuService;
import com.fireflyi.gerant.rpclient.McenterApiServiceGrpc;
import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gerant.rpclient.protobuf.Gres;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/26
 * DESC TODO
 */
@Singleton
public class McenterApiServiceImpl  extends McenterApiServiceGrpc.McenterApiServiceImplBase implements McenterBaseApiService{
    private static final Logger logger = LoggerFactory.getLogger(McenterApiServiceImpl.class);
    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private Set<McenterHandlerAdapter> handlers = new HashSet<McenterHandlerAdapter>();

    @Inject
    UsertuService usertuService;

    @Inject
    public void setHandlers(){
        handlers.add(usertuService);
    }

    @Override
    public void mcPipline(Greq req, StreamObserver<Gres> responseObserver) {
        //异步处理消息
        executor.execute(()-> doHandlers(req));
        //直接返回客户端res
        Gres reply = Gres.newBuilder().setResMsg("来自服务端的信息->111111 " + req.getReqMsg()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }

    /**
     * 并发处理
     * @param req
     */
    public void doHandlers(Greq req){
        for (McenterHandlerAdapter handler : handlers) {
            handler.progress(req);
        }
    }
}
