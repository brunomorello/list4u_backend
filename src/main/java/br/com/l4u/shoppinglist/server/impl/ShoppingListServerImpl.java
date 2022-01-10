package br.com.l4u.shoppinglist.server.impl;

import br.com.l4u.itemcategory.*;
import io.grpc.stub.StreamObserver;

public class ShoppingListServerImpl extends ItemCategoryServiceGrpc.ItemCategoryServiceImplBase {

    @Override
    public void listAllItemCategories(ItemCategoryListRequest request, StreamObserver<ItemCategoryType> responseObserver) {
        for (int i = 0; i < 5; i++) {
            responseObserver.onNext(
                    ItemCategoryType.newBuilder()
                            .setId(String.valueOf(i))
                            .setName("Item: " + i)
                            .setUnitMeasurement(UnitMeasurement.forNumber(i))
                            .build()
            );
        }
        responseObserver.onCompleted();
    }
}