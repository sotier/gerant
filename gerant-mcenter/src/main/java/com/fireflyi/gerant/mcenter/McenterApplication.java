package com.fireflyi.gerant.mcenter;

import com.fireflyi.gerant.mcenter.service.McenterApiServiceImpl;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/26
 * DESC TODO
 */
public class McenterApplication {
    private static final Logger logger = LoggerFactory.getLogger(McenterLaunches.class);

    private Server server;

    @Inject
    private McenterApiServiceImpl mcenterApiService;

    @Inject
    private void start() throws IOException, InterruptedException {
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(mcenterApiService)
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                logger.info("*** shutting down gRPC McenterApplication since JVM is shutting down");
                McenterApplication.this.stop();
                logger.info("*** McenterApplication shut down");
            }
        });

        blockUntilShutdown();
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

}
