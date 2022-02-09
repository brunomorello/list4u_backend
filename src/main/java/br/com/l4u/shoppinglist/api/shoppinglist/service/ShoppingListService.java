package br.com.l4u.shoppinglist.api.shoppinglist.service;

import br.com.l4u.shoppinglist.api.shoppinglist.model.BasketItem;
import br.com.l4u.shoppinglist.api.shoppinglist.model.ShoppingList;
import br.com.l4u.shoppinglist.api.user.model.User;

import java.util.List;

public interface ShoppingListService {
    public ShoppingList create(ShoppingList shoppingList);
    public ShoppingList update(ShoppingList shoppingList);
    public void delete(ShoppingList shoppingList);
    public ShoppingList searchById(String id);
    public List<ShoppingList> searchByName(String name);
    public List<ShoppingList> listAll();
    public List<ShoppingList> getMy(User user);
    public List<ShoppingList> getSharedWith(User user);
    public void addItemToBasket(ShoppingList shoppingList, BasketItem basketItem);
    public void emptyBasket(ShoppingList shoppingList);
    public void addUser(ShoppingList shoppingList, User user);
    public ShoppingList duplicate(ShoppingList shoppingList);
}
