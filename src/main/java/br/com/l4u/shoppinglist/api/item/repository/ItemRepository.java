package br.com.l4u.shoppinglist.api.item.repository;

import br.com.l4u.shoppinglist.api.item.model.Item;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;

import java.util.List;

public interface ItemRepository {
    public Item save(Item item) throws IllegalArgumentException;
    public Item searchById(String id);
    public void delete(String id);
    public List<Item> listAll();
    public List<Item> searchByCategory(ItemCategory category);
    public List<Item> searchByNameLike(String name);
}
