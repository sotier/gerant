package com.fireflyi.gn.gerant.service.service;

import com.fireflyi.gerant.rpclient.McenterApiServiceGrpc;
import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gerant.rpclient.protobuf.Gres;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/26
 * DESC TODO
 */
public class McenterClient {
    private static final Logger logger = Logger.getLogger(McenterClient.class.getName());

    private final ManagedChannel channel;
    private final McenterApiServiceGrpc.McenterApiServiceBlockingStub blockingStub;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public McenterClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct client for accessing HelloWorld server using the existing channel. */
    McenterClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = McenterApiServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /** Say hello to server. */
    public void greet(String name) {
        Greq request = Greq.newBuilder().setReqMsg(name).build();
        Gres response;
        try {
            response = blockingStub.mcPipline(request);
        } catch (StatusRuntimeException e) {
            return;
        }
        logger.info("收到服务端信息返回: " + response.getResMsg());
    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting.
     */
    public static void main(String[] args) throws Exception {
        McenterClient client = new McenterClient("localhost", 50051);
        try {
            /* Access a service running on the local machine on port 50051 */
            String user = "来自客户端的信息->222222222";
            if (args.length > 0) {
                user = args[0]; /* Use the arg as the name to greet if provided */
            }
            client.greet(user);
        } finally {
            client.shutdown();
        }
    }
}
