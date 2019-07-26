package com.fireflyi.gerant.mcenter;

import com.fireflyi.gerant.rpclient.McenterApiServiceGrpc;
import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gerant.rpclient.protobuf.Gres;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/26
 * DESC TODO
 */
public class McenterApplication {

    private static final Logger logger = Logger.getLogger(McenterApplication.class.getName());

    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new McenterApiServiceImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                McenterApplication.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final McenterApplication server = new McenterApplication();
        server.start();
        server.blockUntilShutdown();
    }

    static class McenterApiServiceImpl extends McenterApiServiceGrpc.McenterApiServiceImplBase {

        @Override
        public void mcPipline(Greq req, StreamObserver<Gres> responseObserver) {
            Gres reply = Gres.newBuilder().setResMsg("来自服务端的信息->111111 " + req.getReqMsg()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

}
