package br.com.l4u.shoppinglist.server;

import br.com.l4u.shoppinglist.api.item.service.ItemGrpcServiceImpl;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<BindableService> services = new ArrayList<>();

        Server server = ServerBuilder.forPort(50051)
                .addService(new ItemGrpcServiceImpl())
                .build();
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutdown request");
            server.shutdown();
            System.out.println("Successfully stopped the server");
        }));
        server.awaitTermination();
    }
}
