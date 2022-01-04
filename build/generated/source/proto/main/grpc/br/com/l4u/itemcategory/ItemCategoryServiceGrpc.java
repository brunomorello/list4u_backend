package br.com.l4u.itemcategory;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.1)",
    comments = "Source: itemcategory/itemcategory.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ItemCategoryServiceGrpc {

  private ItemCategoryServiceGrpc() {}

  public static final String SERVICE_NAME = "itemcategory.ItemCategoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<br.com.l4u.itemcategory.ItemCategoryListRequest,
      br.com.l4u.itemcategory.ItemCategoryListResponse> getListAllItemCategoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAllItemCategories",
      requestType = br.com.l4u.itemcategory.ItemCategoryListRequest.class,
      responseType = br.com.l4u.itemcategory.ItemCategoryListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.l4u.itemcategory.ItemCategoryListRequest,
      br.com.l4u.itemcategory.ItemCategoryListResponse> getListAllItemCategoriesMethod() {
    io.grpc.MethodDescriptor<br.com.l4u.itemcategory.ItemCategoryListRequest, br.com.l4u.itemcategory.ItemCategoryListResponse> getListAllItemCategoriesMethod;
    if ((getListAllItemCategoriesMethod = ItemCategoryServiceGrpc.getListAllItemCategoriesMethod) == null) {
      synchronized (ItemCategoryServiceGrpc.class) {
        if ((getListAllItemCategoriesMethod = ItemCategoryServiceGrpc.getListAllItemCategoriesMethod) == null) {
          ItemCategoryServiceGrpc.getListAllItemCategoriesMethod = getListAllItemCategoriesMethod =
              io.grpc.MethodDescriptor.<br.com.l4u.itemcategory.ItemCategoryListRequest, br.com.l4u.itemcategory.ItemCategoryListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAllItemCategories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.l4u.itemcategory.ItemCategoryListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.l4u.itemcategory.ItemCategoryListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ItemCategoryServiceMethodDescriptorSupplier("ListAllItemCategories"))
              .build();
        }
      }
    }
    return getListAllItemCategoriesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ItemCategoryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ItemCategoryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ItemCategoryServiceStub>() {
        @java.lang.Override
        public ItemCategoryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ItemCategoryServiceStub(channel, callOptions);
        }
      };
    return ItemCategoryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ItemCategoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ItemCategoryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ItemCategoryServiceBlockingStub>() {
        @java.lang.Override
        public ItemCategoryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ItemCategoryServiceBlockingStub(channel, callOptions);
        }
      };
    return ItemCategoryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ItemCategoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ItemCategoryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ItemCategoryServiceFutureStub>() {
        @java.lang.Override
        public ItemCategoryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ItemCategoryServiceFutureStub(channel, callOptions);
        }
      };
    return ItemCategoryServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ItemCategoryServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void listAllItemCategories(br.com.l4u.itemcategory.ItemCategoryListRequest request,
        io.grpc.stub.StreamObserver<br.com.l4u.itemcategory.ItemCategoryListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAllItemCategoriesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListAllItemCategoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                br.com.l4u.itemcategory.ItemCategoryListRequest,
                br.com.l4u.itemcategory.ItemCategoryListResponse>(
                  this, METHODID_LIST_ALL_ITEM_CATEGORIES)))
          .build();
    }
  }

  /**
   */
  public static final class ItemCategoryServiceStub extends io.grpc.stub.AbstractAsyncStub<ItemCategoryServiceStub> {
    private ItemCategoryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ItemCategoryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ItemCategoryServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void listAllItemCategories(br.com.l4u.itemcategory.ItemCategoryListRequest request,
        io.grpc.stub.StreamObserver<br.com.l4u.itemcategory.ItemCategoryListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAllItemCategoriesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ItemCategoryServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ItemCategoryServiceBlockingStub> {
    private ItemCategoryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ItemCategoryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ItemCategoryServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public br.com.l4u.itemcategory.ItemCategoryListResponse listAllItemCategories(br.com.l4u.itemcategory.ItemCategoryListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAllItemCategoriesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ItemCategoryServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ItemCategoryServiceFutureStub> {
    private ItemCategoryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ItemCategoryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ItemCategoryServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.l4u.itemcategory.ItemCategoryListResponse> listAllItemCategories(
        br.com.l4u.itemcategory.ItemCategoryListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAllItemCategoriesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ALL_ITEM_CATEGORIES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ItemCategoryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ItemCategoryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ALL_ITEM_CATEGORIES:
          serviceImpl.listAllItemCategories((br.com.l4u.itemcategory.ItemCategoryListRequest) request,
              (io.grpc.stub.StreamObserver<br.com.l4u.itemcategory.ItemCategoryListResponse>) responseObserver);
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

  private static abstract class ItemCategoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ItemCategoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.l4u.itemcategory.Itemcategory.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ItemCategoryService");
    }
  }

  private static final class ItemCategoryServiceFileDescriptorSupplier
      extends ItemCategoryServiceBaseDescriptorSupplier {
    ItemCategoryServiceFileDescriptorSupplier() {}
  }

  private static final class ItemCategoryServiceMethodDescriptorSupplier
      extends ItemCategoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ItemCategoryServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ItemCategoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ItemCategoryServiceFileDescriptorSupplier())
              .addMethod(getListAllItemCategoriesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
