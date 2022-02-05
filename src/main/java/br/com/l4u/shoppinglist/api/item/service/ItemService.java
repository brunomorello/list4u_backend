package br.com.l4u.shoppinglist.api.item.service;

import br.com.l4u.item.*;
import br.com.l4u.shoppinglist.config.DatabaseConfig;
import br.com.l4u.shoppinglist.api.item.mapper.ItemMapper;
import br.com.l4u.shoppinglist.api.item.mapper.impl.ItemMapperImpl;
import br.com.l4u.shoppinglist.api.item.model.Item;
import br.com.l4u.shoppinglist.api.item.repository.ItemRepository;
import br.com.l4u.shoppinglist.api.item.repository.impl.ItemRepositoryImpl;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class ItemService extends ItemServiceGrpc.ItemServiceImplBase {

    ItemMapper mapper = new ItemMapperImpl();
    ItemRepository repository = new ItemRepositoryImpl(new DatabaseConfig());

    @Override
    public void create(ItemRequest request, StreamObserver<ItemType> responseObserver) {
        Item item = mapper.toModel(request);
        try {
            Item itemCreated = repository.save(item);
            responseObserver.onNext(mapper.parse(itemCreated));
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("Error to create Item")
                            .asRuntimeException()
            );
        }
    }

    @Override
    public void update(ItemUpdateRequest request, StreamObserver<ItemType> responseObserver) {
        Item item = mapper.toModel(request);
        try {
            Item itemUpdated = repository.save(item);
            responseObserver.onNext(mapper.parse(itemUpdated));
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("Error to Update Item")
                            .asRuntimeException()
            );
        }
    }

    @Override
    public void searchById(ItemSearchByIdRequest request, StreamObserver<ItemType> responseObserver) {
        Item itemFound = repository.searchById(request.getId());
        if (itemFound != null) {
            responseObserver.onNext(mapper.parse(itemFound));
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("Item Not Found by ID " + request.getId())
                            .asRuntimeException()
            );
        }
    }

    @Override
    public void delete(ItemDeleteRequest request, StreamObserver<ItemType> responseObserver) {
        super.delete(request, responseObserver);
    }

    @Override
    public void searchByCategory(ItemsSearchByNameLikeRequest request, StreamObserver<ItemType> responseObserver) {
        super.searchByCategory(request, responseObserver);
    }

    @Override
    public void searchByNameLike(ItemsSearchByNameLikeRequest request, StreamObserver<ItemType> responseObserver) {
        super.searchByNameLike(request, responseObserver);
    }
}
