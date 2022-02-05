package br.com.l4u.shoppinglist.api.itemcategory.mapper;

import br.com.l4u.itemcategory.CreateItemCategoryRequest;
import br.com.l4u.itemcategory.ItemCategoryType;
import br.com.l4u.itemcategory.UpdateItemCategoryRequest;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;
import org.bson.Document;

public interface ItemCategoryMapper {
    public ItemCategoryType parse(ItemCategory itemCategory);
    public ItemCategory toModel(UpdateItemCategoryRequest itemCategoryType);
    public ItemCategory toModel(CreateItemCategoryRequest request);
    public ItemCategory toModel(ItemCategoryType itemCategoryType);
    public ItemCategory documentToModel(Document document);
}
