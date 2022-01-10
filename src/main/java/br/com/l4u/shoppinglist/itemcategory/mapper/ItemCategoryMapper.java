package br.com.l4u.shoppinglist.itemcategory.mapper;

import br.com.l4u.itemcategory.CreateItemCategoryRequest;
import br.com.l4u.itemcategory.ItemCategoryType;
import br.com.l4u.shoppinglist.itemcategory.model.ItemCategory;

public interface ItemCategoryMapper {
    public ItemCategoryType parse(ItemCategory itemCategory);
    public ItemCategory toModel(ItemCategoryType itemCategoryType);
    public ItemCategory toModel(CreateItemCategoryRequest request);
}
