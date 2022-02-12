package br.com.l4u.shoppinglist.api.itemcategory.mapper.impl;

import br.com.l4u.itemcategory.CreateItemCategoryRequest;
import br.com.l4u.itemcategory.ItemCategoryType;
import br.com.l4u.itemcategory.UpdateItemCategoryRequest;
import br.com.l4u.shoppinglist.api.itemcategory.mapper.ItemCategoryMapper;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;
import org.bson.Document;

public class ItemCategoryMapperImpl implements ItemCategoryMapper {

    @Override
    public ItemCategoryType parse(ItemCategory itemCategory) {
        return ItemCategoryType.newBuilder()
                .setId(itemCategory.getId().toString())
                .setName(itemCategory.getName())
                .build();
    }

    @Override
    public ItemCategory toModel(UpdateItemCategoryRequest itemCategoryType) {
        return new ItemCategory(
                itemCategoryType.getId(),
                itemCategoryType.getName()
        );
    }

    @Override
    public ItemCategory toModel(CreateItemCategoryRequest itemCategoryType) {
        return new ItemCategory(
                null,
                itemCategoryType.getName()
        );
    }

    @Override
    public ItemCategory toModel(ItemCategoryType itemCategoryType) {
        return new ItemCategory(
                itemCategoryType.getId(),
                itemCategoryType.getName()
        );
    }

    @Override
    public ItemCategory documentToModel(Document document) {
        return new ItemCategory(
                document.getObjectId("_id").toString(),
                document.getString("name")
        );
    }
}
