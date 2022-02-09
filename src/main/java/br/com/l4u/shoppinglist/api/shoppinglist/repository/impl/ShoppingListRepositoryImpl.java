package br.com.l4u.shoppinglist.api.shoppinglist.repository.impl;

import br.com.l4u.shoppinglist.api.shoppinglist.model.ShoppingList;
import br.com.l4u.shoppinglist.api.shoppinglist.repository.ShoppingListRepository;
import br.com.l4u.shoppinglist.infra.config.db.DatabaseConfig;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;
import java.util.Optional;

public class ShoppingListRepositoryImpl implements ShoppingListRepository {

    private DatabaseConfig dbConfig;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    public ShoppingListRepositoryImpl(DatabaseConfig dbConfig) {
        this.dbConfig = dbConfig;
        this.db = dbConfig.mongoDb();
        this.collection = db.getCollection("ShoppingList");
    }

    @Override
    public ShoppingList save(ShoppingList shoppingList) {
        return null;
    }

    @Override
    public void delete(ShoppingList shoppingList) {

    }

    @Override
    public Optional<ShoppingList> searchById(String id) {
        return null;
    }

    @Override
    public List<ShoppingList> searchByName(String name) {
        return null;
    }

    @Override
    public List<ShoppingList> listAll() {
        return null;
    }
}
