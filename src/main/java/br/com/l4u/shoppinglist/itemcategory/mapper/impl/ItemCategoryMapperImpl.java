package br.com.l4u.shoppinglist.itemcategory.mapper.impl;

import br.com.l4u.itemcategory.CreateItemCategoryRequest;
import br.com.l4u.itemcategory.ItemCategoryType;
import br.com.l4u.shoppinglist.itemcategory.mapper.ItemCategoryMapper;
import br.com.l4u.shoppinglist.itemcategory.model.ItemCategory;

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
    public ItemCategory toModel(ItemCategoryType itemCategoryType) {
        return new ItemCategory(
                itemCategoryType.getId(),
                itemCategoryType.getName(),
                itemCategoryType.getUnitMeasurement()
        );
    }

    @Override
    public ItemCategory toModel(CreateItemCategoryRequest request) {
        return new ItemCategory(
                null,
                request.getName(),
                request.getUnitMeasurement()
        );
    }
}
