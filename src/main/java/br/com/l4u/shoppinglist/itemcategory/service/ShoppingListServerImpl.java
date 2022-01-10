package br.com.l4u.shoppinglist.itemcategory.service;

import br.com.l4u.itemcategory.*;
import br.com.l4u.shoppinglist.config.DatabaseConfig;
import br.com.l4u.shoppinglist.itemcategory.mapper.ItemCategoryMapper;
import br.com.l4u.shoppinglist.itemcategory.mapper.impl.ItemCategoryMapperImpl;
import br.com.l4u.shoppinglist.itemcategory.model.ItemCategory;
import br.com.l4u.shoppinglist.itemcategory.repository.ItemCategoryRepository;
import br.com.l4u.shoppinglist.itemcategory.repository.impl.ItemCategoryRepositoryImpl;
import io.grpc.stub.StreamObserver;

public class ShoppingListServerImpl extends ItemCategoryServiceGrpc.ItemCategoryServiceImplBase {

    ItemCategoryMapper mapper = new ItemCategoryMapperImpl();
    ItemCategoryRepository repository = new ItemCategoryRepositoryImpl(new DatabaseConfig());

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

    @Override
    public void createItemCategory(CreateItemCategoryRequest request, StreamObserver<ItemCategoryType> responseObserver) {
        ItemCategory itemCategory = mapper.toModel(request);
        repository.save(itemCategory);
        responseObserver.onNext(mapper.parse(itemCategory));
        responseObserver.onCompleted();
    }
}