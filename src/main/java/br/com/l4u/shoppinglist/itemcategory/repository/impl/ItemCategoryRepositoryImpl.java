package br.com.l4u.shoppinglist.itemcategory.repository.impl;

import br.com.l4u.shoppinglist.config.DatabaseConfig;
import br.com.l4u.shoppinglist.itemcategory.model.ItemCategory;
import br.com.l4u.shoppinglist.itemcategory.repository.ItemCategoryRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;
import java.util.UUID;

public class ItemCategoryRepositoryImpl implements ItemCategoryRepository {

    private DatabaseConfig dbConfig;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    public ItemCategoryRepositoryImpl(DatabaseConfig dbConfig) {
        this.dbConfig = dbConfig;
        this.db = dbConfig.mongoDb();
        this.collection = db.getCollection("ItemCategory");
    }

    @Override
    public ItemCategory save(ItemCategory itemCategory) {
//        itemCategory.setId(UUID.randomUUID());

        Document doc = new Document()
//                .append("id", itemCategory.getId().toString())
                .append("name", itemCategory.getName())
                .append("unitMeasurement", itemCategory.getUnitMeasurement().toString());

        System.out.println("inserting new item category");

        collection.insertOne(doc);
        String id = doc.getObjectId("_id").toString();
        System.out.println("Item Category created with id " + id);
        itemCategory.setId(id);

        return itemCategory;
    }

    @Override
    public List<ItemCategory> listAll() {
        return null;
    }
}
