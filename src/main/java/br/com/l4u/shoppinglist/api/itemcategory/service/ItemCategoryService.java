package br.com.l4u.shoppinglist.api.itemcategory.service;

import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;

import java.util.List;

public interface ItemCategoryService {
    public List<ItemCategory> listAllItemCategories();
    public ItemCategory createItemCategory(ItemCategory itemCategory);
    public ItemCategory updateItemCategory(ItemCategory itemCategory);
}
