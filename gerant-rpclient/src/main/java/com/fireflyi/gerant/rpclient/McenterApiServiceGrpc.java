package com.fireflyi.gerant.rpclient;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0-SNAPSHOT)",
    comments = "Source: McenterApiService.proto")
public final class McenterApiServiceGrpc {

  private McenterApiServiceGrpc() {}

  public static final String SERVICE_NAME = "protobuf.McenterApiService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.fireflyi.gerant.rpclient.protobuf.Greq,
      com.fireflyi.gerant.rpclient.protobuf.Gres> getMcPiplineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "mcPipline",
      requestType = com.fireflyi.gerant.rpclient.protobuf.Greq.class,
      responseType = com.fireflyi.gerant.rpclient.protobuf.Gres.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.fireflyi.gerant.rpclient.protobuf.Greq,
      com.fireflyi.gerant.rpclient.protobuf.Gres> getMcPiplineMethod() {
    io.grpc.MethodDescriptor<com.fireflyi.gerant.rpclient.protobuf.Greq, com.fireflyi.gerant.rpclient.protobuf.Gres> getMcPiplineMethod;
    if ((getMcPiplineMethod = McenterApiServiceGrpc.getMcPiplineMethod) == null) {
      synchronized (McenterApiServiceGrpc.class) {
        if ((getMcPiplineMethod = McenterApiServiceGrpc.getMcPiplineMethod) == null) {
          McenterApiServiceGrpc.getMcPiplineMethod = getMcPiplineMethod =
              io.grpc.MethodDescriptor.<com.fireflyi.gerant.rpclient.protobuf.Greq, com.fireflyi.gerant.rpclient.protobuf.Gres>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "mcPipline"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.fireflyi.gerant.rpclient.protobuf.Greq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.fireflyi.gerant.rpclient.protobuf.Gres.getDefaultInstance()))
              .setSchemaDescriptor(new McenterApiServiceMethodDescriptorSupplier("mcPipline"))
              .build();
        }
      }
    }
    return getMcPiplineMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static McenterApiServiceStub newStub(io.grpc.Channel channel) {
    return new McenterApiServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static McenterApiServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new McenterApiServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static McenterApiServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new McenterApiServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class McenterApiServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void mcPipline(com.fireflyi.gerant.rpclient.protobuf.Greq request,
        io.grpc.stub.StreamObserver<com.fireflyi.gerant.rpclient.protobuf.Gres> responseObserver) {
      asyncUnimplementedUnaryCall(getMcPiplineMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMcPiplineMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.fireflyi.gerant.rpclient.protobuf.Greq,
                com.fireflyi.gerant.rpclient.protobuf.Gres>(
                  this, METHODID_MC_PIPLINE)))
          .build();
    }
  }

  /**
   */
  public static final class McenterApiServiceStub extends io.grpc.stub.AbstractStub<McenterApiServiceStub> {
    private McenterApiServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private McenterApiServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected McenterApiServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new McenterApiServiceStub(channel, callOptions);
    }

    /**
     */
    public void mcPipline(com.fireflyi.gerant.rpclient.protobuf.Greq request,
        io.grpc.stub.StreamObserver<com.fireflyi.gerant.rpclient.protobuf.Gres> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMcPiplineMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class McenterApiServiceBlockingStub extends io.grpc.stub.AbstractStub<McenterApiServiceBlockingStub> {
    private McenterApiServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private McenterApiServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected McenterApiServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new McenterApiServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.fireflyi.gerant.rpclient.protobuf.Gres mcPipline(com.fireflyi.gerant.rpclient.protobuf.Greq request) {
      return blockingUnaryCall(
          getChannel(), getMcPiplineMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class McenterApiServiceFutureStub extends io.grpc.stub.AbstractStub<McenterApiServiceFutureStub> {
    private McenterApiServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private McenterApiServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected McenterApiServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new McenterApiServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.fireflyi.gerant.rpclient.protobuf.Gres> mcPipline(
        com.fireflyi.gerant.rpclient.protobuf.Greq request) {
      return futureUnaryCall(
          getChannel().newCall(getMcPiplineMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MC_PIPLINE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final McenterApiServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(McenterApiServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MC_PIPLINE:
          serviceImpl.mcPipline((com.fireflyi.gerant.rpclient.protobuf.Greq) request,
              (io.grpc.stub.StreamObserver<com.fireflyi.gerant.rpclient.protobuf.Gres>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class McenterApiServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    McenterApiServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.fireflyi.gerant.rpclient.McenterApiServicePtc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("McenterApiService");
    }
  }

  private static final class McenterApiServiceFileDescriptorSupplier
      extends McenterApiServiceBaseDescriptorSupplier {
    McenterApiServiceFileDescriptorSupplier() {}
  }

  private static final class McenterApiServiceMethodDescriptorSupplier
      extends McenterApiServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    McenterApiServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (McenterApiServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new McenterApiServiceFileDescriptorSupplier())
              .addMethod(getMcPiplineMethod())
              .build();
        }
      }
    }
    return result;
  }
}
