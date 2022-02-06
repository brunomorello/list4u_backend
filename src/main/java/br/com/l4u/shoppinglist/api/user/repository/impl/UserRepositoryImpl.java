package br.com.l4u.shoppinglist.api.user.repository.impl;

import br.com.l4u.shoppinglist.api.user.model.User;
import br.com.l4u.shoppinglist.api.user.repository.UserRepository;
import br.com.l4u.shoppinglist.infra.config.db.DatabaseConfig;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private DatabaseConfig dbConfig;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    public UserRepositoryImpl(DatabaseConfig dbConfig) {
        this.dbConfig = dbConfig;
        this.db = dbConfig.mongoDb();
        this.collection = db.getCollection("User");
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> searchById(String id) {
        return null;
    }

    @Override
    public List<User> listAll() {
        return null;
    }
}
