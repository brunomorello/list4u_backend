package br.com.l4u.shoppinglist.api.itemcategory.service;

import br.com.l4u.itemcategory.*;
import br.com.l4u.shoppinglist.infra.config.db.DatabaseConfig;
import br.com.l4u.shoppinglist.api.itemcategory.mapper.ItemCategoryMapper;
import br.com.l4u.shoppinglist.api.itemcategory.mapper.impl.ItemCategoryMapperImpl;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;
import br.com.l4u.shoppinglist.api.itemcategory.repository.ItemCategoryRepository;
import br.com.l4u.shoppinglist.api.itemcategory.repository.impl.ItemCategoryRepositoryImpl;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class ItemCategoryGrpcServiceImpl extends ItemCategoryServiceGrpc.ItemCategoryServiceImplBase {

    ItemCategoryMapper mapper = new ItemCategoryMapperImpl();
    ItemCategoryRepository repository = new ItemCategoryRepositoryImpl(new DatabaseConfig());

    @Override
    public void listAllItemCategories(ItemCategoryListRequest request, StreamObserver<ItemCategoryType> responseObserver) {
        repository.listAll().forEach(item -> {
            responseObserver.onNext(
                    ItemCategoryType.newBuilder()
                            .setId(item.getId())
                            .setName(item.getName())
                            .setUnitMeasurement(item.getUnitMeasurement())
                            .build()
            );
        });
        responseObserver.onCompleted();
    }

    @Override
    public void createItemCategory(CreateItemCategoryRequest request, StreamObserver<ItemCategoryType> responseObserver) {
        ItemCategory itemCategory = mapper.toModel(request);
        try {
            ItemCategory response = repository.save(itemCategory);
            responseObserver.onNext(mapper.parse(response));
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("Error to create ItemCategory")
                            .asRuntimeException()
            );
        }
    }

    @Override
    public void updateItemCategory(UpdateItemCategoryRequest request, StreamObserver<ItemCategoryType> responseObserver) {
        ItemCategory itemCategory = mapper.toModel(request);
        try {
            ItemCategory response = repository.save(itemCategory);
            responseObserver.onNext(mapper.parse(response));
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("Error to update ItemCategory")
                            .asRuntimeException()
            );
        }

    }
}