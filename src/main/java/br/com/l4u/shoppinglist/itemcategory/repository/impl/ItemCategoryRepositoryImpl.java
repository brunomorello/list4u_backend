package br.com.l4u.shoppinglist.itemcategory.repository.impl;

import br.com.l4u.shoppinglist.config.DatabaseConfig;
import br.com.l4u.shoppinglist.itemcategory.mapper.ItemCategoryMapper;
import br.com.l4u.shoppinglist.itemcategory.mapper.impl.ItemCategoryMapperImpl;
import br.com.l4u.shoppinglist.itemcategory.model.ItemCategory;
import br.com.l4u.shoppinglist.itemcategory.repository.ItemCategoryRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ItemCategoryRepositoryImpl implements ItemCategoryRepository {

    private DatabaseConfig dbConfig;
    private MongoDatabase db;
    private MongoCollection<Document> collection;
    private ItemCategoryMapper mapper;

    public ItemCategoryRepositoryImpl(DatabaseConfig dbConfig) {
        this.dbConfig = dbConfig;
        this.db = dbConfig.mongoDb();
        this.collection = db.getCollection("ItemCategory");
        this.mapper = new ItemCategoryMapperImpl();
    }

    @Override
    public ItemCategory save(ItemCategory itemCategory) throws IllegalArgumentException {

        if (itemCategory.getId() == null || itemCategory.getId().isEmpty()) {
            return create(itemCategory);
        } else {
            update(itemCategory);
            return itemCategory;
        }
    }

    private ItemCategory create(ItemCategory itemCategory) {
        Document doc = new Document()
                .append("name", itemCategory.getName())
                .append("unitMeasurement", itemCategory.getUnitMeasurement().toString());

        System.out.println("Inserting new ItemCategory...");

        collection.insertOne(doc);
        String id = doc.getObjectId("_id").toString();

        System.out.println("ItemCategory created with id " + id);
        itemCategory.setId(id);

        return itemCategory;
    }

    private void update(ItemCategory itemCategory) throws IllegalArgumentException{
        Document doc = collection.find(eq("_id", new ObjectId(itemCategory.getId()))).first();
        if (doc == null)
            throw new IllegalArgumentException();

        Document updatedDoc = new Document()
                .append("_id", new ObjectId(itemCategory.getId()))
                .append("name", itemCategory.getName())
                .append("unitMeasurement", itemCategory.getUnitMeasurement().toString());

        System.out.println("Updating ItemCategory with id " + itemCategory.getId() + "...");

        collection.replaceOne(eq("_id", doc.getObjectId("_id")), updatedDoc);

        System.out.println("ItemCategory #" + updatedDoc.getObjectId("_id") + " updated");

    }
    @Override
    public List<ItemCategory> listAll() {
        System.out.println("Listing All ItemCategories...");
        List<ItemCategory> response = new ArrayList<>();

        collection.find().iterator().forEachRemaining(
                document -> response.add(mapper.documentToModel(document))
        );
        return response;
    }
}
