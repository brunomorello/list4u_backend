package br.com.l4u.shoppinglist.api.itemcategory.repository;

import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;

import java.util.List;

public interface ItemCategoryRepository {
    public ItemCategory save(ItemCategory itemCategory) throws IllegalArgumentException;
    public List<ItemCategory> listAll();
}
