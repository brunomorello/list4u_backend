package br.com.l4u.shoppinglist.itemcategory.repository;

import br.com.l4u.itemcategory.ItemCategoryType;
import br.com.l4u.shoppinglist.itemcategory.model.ItemCategory;

import java.util.List;

public interface ItemCategoryRepository {
    public ItemCategory save(ItemCategory itemCategory);
    public List<ItemCategory> listAll();
}
