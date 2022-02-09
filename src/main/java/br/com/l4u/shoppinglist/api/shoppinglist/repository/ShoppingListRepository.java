package br.com.l4u.shoppinglist.api.shoppinglist.repository;

import br.com.l4u.shoppinglist.api.shoppinglist.model.ShoppingList;

import java.util.List;
import java.util.Optional;

public interface ShoppingListRepository {
    public ShoppingList save(ShoppingList shoppingList);
    public void delete(ShoppingList shoppingList);
    public Optional<ShoppingList> searchById(String id);
    public List<ShoppingList> searchByName(String name);
    public List<ShoppingList> listAll();
}
