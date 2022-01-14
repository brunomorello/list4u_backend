package br.com.l4u.shoppinglist.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;

public class DatabaseConfig {

    private String dbUrl = "mongodb://root:dqm50vnc@localhost:27017";
    private String dbName = "list4u";
    private String dbUser = "root";
    private String dbPasswod = "dqm50vnc";

    public MongoDatabase mongoDb() {
        MongoClient mongoClient = MongoClients.create(dbUrl);
        return mongoClient.getDatabase(dbName);
    }
}
