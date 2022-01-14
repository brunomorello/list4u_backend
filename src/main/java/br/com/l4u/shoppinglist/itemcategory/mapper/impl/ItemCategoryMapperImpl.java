package br.com.l4u.shoppinglist.itemcategory.mapper.impl;

import br.com.l4u.itemcategory.CreateItemCategoryRequest;
import br.com.l4u.itemcategory.ItemCategoryType;
import br.com.l4u.itemcategory.UnitMeasurement;
import br.com.l4u.itemcategory.UpdateItemCategoryRequest;
import br.com.l4u.shoppinglist.itemcategory.mapper.ItemCategoryMapper;
import br.com.l4u.shoppinglist.itemcategory.model.ItemCategory;
import org.bson.Document;

import java.util.UUID;

public class ItemCategoryMapperImpl implements ItemCategoryMapper {

    @Override
    public ItemCategoryType parse(ItemCategory itemCategory) {
        return ItemCategoryType.newBuilder()
                .setId(itemCategory.getId().toString())
                .setName(itemCategory.getName())
                .setUnitMeasurement(itemCategory.getUnitMeasurement())
                .build();
    }

    @Override
    public ItemCategory toModel(UpdateItemCategoryRequest itemCategoryType) {
        return new ItemCategory(
                itemCategoryType.getId(),
                itemCategoryType.getName(),
                itemCategoryType.getUnitMeasurement()
        );
    }

    @Override
    public ItemCategory toModel(CreateItemCategoryRequest itemCategoryType) {
        return new ItemCategory(
                null,
                itemCategoryType.getName(),
                itemCategoryType.getUnitMeasurement()
        );
    }

    @Override
    public ItemCategory documentToModel(Document document) {
        return new ItemCategory(
                document.getObjectId("_id").toString(),
                document.getString("name"),
                UnitMeasurement.valueOf(document.getString("unitMeasurement"))
        );
    }
}
