package br.com.l4u.shoppinglist.api.item.mapper.impl;

import br.com.l4u.item.ItemRequest;
import br.com.l4u.item.ItemType;
import br.com.l4u.item.ItemUpdateRequest;
import br.com.l4u.shoppinglist.api.item.mapper.ItemMapper;
import br.com.l4u.shoppinglist.api.item.model.Item;
import br.com.l4u.shoppinglist.api.itemcategory.mapper.ItemCategoryMapper;
import br.com.l4u.shoppinglist.api.itemcategory.mapper.impl.ItemCategoryMapperImpl;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;
import org.bson.Document;

public class ItemMapperImpl implements ItemMapper {

    private ItemCategoryMapper itemCategoryMapper = new ItemCategoryMapperImpl();

    @Override
    public ItemType parse(Item item) {
        return ItemType.newBuilder()
                .setId(item.getId())
                .setName(item.getName())
                .setCategory(itemCategoryMapper.parse(item.getCategory()))
                .build();
    }

    @Override
    public Item toModel(ItemUpdateRequest request) {
        return new Item(
                request.getId(),
                request.getName(),
                itemCategoryMapper.toModel(request.getCategory())
        );
    }

    @Override
    public Item toModel(ItemRequest request) {
        return new Item(
                null,
                request.getName(),
                itemCategoryMapper.toModel(request.getCategory())
        );
    }

    @Override
    public Item documentToModel(Document document) {
        return new Item(
                document.getObjectId("_id").toString(),
                document.getString("name"),
                (ItemCategory) document.get("category")
        );
    }
}
