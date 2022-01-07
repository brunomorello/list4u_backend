package br.com.l4u.shoppinglist.server.impl;

import br.com.l4u.itemcategory.ItemCategoriesResponse;
import br.com.l4u.itemcategory.ItemCategoryListRequest;
import br.com.l4u.itemcategory.ItemCategoryServiceGrpc;
import io.grpc.stub.StreamObserver;

public class ShoppingListServerImpl extends ItemCategoryServiceGrpc.ItemCategoryServiceImplBase {

    @Override
    public void listAllItemCategories(ItemCategoryListRequest request, StreamObserver<ItemCategoriesResponse> responseObserver) {
        for (int i = 0; i < 10; i++) {
            responseObserver.onNext(
                    ItemCategoriesResponse.newBuilder()
                            .setId(String.valueOf(i))
                            .setName(String.valueOf(i))
                            .build()
            );
        }
        responseObserver.onCompleted();
    }
}
