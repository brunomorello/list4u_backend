package br.com.l4u.shoppinglist.api.item.service;

import br.com.l4u.shoppinglist.api.item.model.Item;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    public Item create(Item item);
    public Item update(Item item);
    public void delete(Item item);
    public List<Item> listAll();
    public Optional<Item> searchById(String id);
    public List<Item> searchByNameLike(String name);
    public List<Item> searchByCategory(ItemCategory itemCategory);
}
