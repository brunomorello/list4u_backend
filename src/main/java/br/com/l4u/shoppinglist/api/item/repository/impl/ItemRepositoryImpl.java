package br.com.l4u.shoppinglist.api.item.repository.impl;

import br.com.l4u.shoppinglist.infra.config.db.DatabaseConfig;
import br.com.l4u.shoppinglist.api.item.mapper.ItemMapper;
import br.com.l4u.shoppinglist.api.item.mapper.impl.ItemMapperImpl;
import br.com.l4u.shoppinglist.api.item.model.Item;
import br.com.l4u.shoppinglist.api.item.repository.ItemRepository;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ItemRepositoryImpl implements ItemRepository {

    private DatabaseConfig dbConfig;
    private MongoDatabase db;
    private MongoCollection<Document> collection;
    private ItemMapper mapper;

    public ItemRepositoryImpl(DatabaseConfig dbConfig) {
        this.dbConfig = dbConfig;
        this.db = dbConfig.mongoDb();
        this.collection = db.getCollection("Item");
        this.mapper = new ItemMapperImpl();
    }

    @Override
    public Item save(Item item) throws IllegalArgumentException{
        if (item.getId() == null || item.getId().isEmpty()) {
            return create(item);
        } else {
            return update(item);
        }
    }

    private Item update(Item item) throws IllegalArgumentException{
        Document doc = (Document) collection.find(eq("_id", new ObjectId(item.getId())));
        if (doc == null)
            throw new IllegalArgumentException();

        Document updatedDoc = new Document()
                .append("_id", new ObjectId(item.getId()))
                .append("name", item.getName())
                .append("category", item.getCategory());

        System.out.println("Updating Item with id " + item.getId());

        collection.replaceOne(eq("_id", doc.getObjectId("_id")), updatedDoc);

        return item;
    }

    private Item create(Item item) {
        Document doc = new Document()
                .append("name", item.getName())
                .append("category", item.getCategory());
        System.out.println("Inserting new Item...");

        collection.insertOne(doc);
        String id = doc.getObjectId("_id").toString();

        System.out.println("Item created with id " + id);
        item.setId(id);

        return item;
    }

    @Override
    public Item searchById(String id) {
        Document doc = (Document) collection.find(eq("_id", new ObjectId(id)));
        return mapper.documentToModel(doc);
    }

    @Override
    public Item delete(String id) {
        return null;
    }

    @Override
    public List<Item> listAll() {
        System.out.println("Listing All Items...");
        List<Item> response = new ArrayList<>();

        collection.find().iterator().forEachRemaining(
                document -> response.add(mapper.documentToModel(document))
        );
        return response;
    }

    @Override
    public List<Item> searchByCategory(ItemCategory category) {
        return null;
    }

    @Override
    public List<Item> searchByNameLike(String name) {
        return null;
    }
}
