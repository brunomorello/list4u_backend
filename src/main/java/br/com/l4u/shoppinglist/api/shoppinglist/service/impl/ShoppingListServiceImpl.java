package br.com.l4u.shoppinglist.api.shoppinglist.service.impl;

import br.com.l4u.shoppinglist.api.shoppinglist.model.BasketItem;
import br.com.l4u.shoppinglist.api.shoppinglist.model.ShoppingList;
import br.com.l4u.shoppinglist.api.shoppinglist.service.ShoppingListService;
import br.com.l4u.shoppinglist.api.user.model.User;

import java.util.List;

public class ShoppingListServiceImpl implements ShoppingListService {

    @Override
    public ShoppingList create(ShoppingList shoppingList) {
        return null;
    }

    @Override
    public ShoppingList update(ShoppingList shoppingList) {
        return null;
    }

    @Override
    public void delete(ShoppingList shoppingList) {

    }

    @Override
    public ShoppingList searchById(String id) {
        return null;
    }

    @Override
    public List<ShoppingList> searchByName(String name) {
        return null;
    }

    @Override
    public List<ShoppingList> listAll() {
        return null;
    }

    @Override
    public List<ShoppingList> getMy(User user) {
        return null;
    }

    @Override
    public List<ShoppingList> getSharedWith(User user) {
        return null;
    }

    @Override
    public void addItemToBasket(ShoppingList shoppingList, BasketItem basketItem) {

    }

    @Override
    public void emptyBasket(ShoppingList shoppingList) {

    }

    @Override
    public void addUser(ShoppingList shoppingList, User user) {

    }

    @Override
    public ShoppingList duplicate(ShoppingList shoppingList) {
        return null;
    }
}
