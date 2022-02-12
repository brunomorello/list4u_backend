package br.com.l4u.shoppinglist.api.shoppinglist.model;

import br.com.l4u.shoppinglist.api.user.model.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode
public class ShoppingList {
    private String id;
    private String name;
    private User createdBy;
    private Set<User> sharedUsers;
    private Basket basket;

    public ShoppingList(User createdBy) {
        this.sharedUsers = new HashSet<>();
        this.basket = new Basket();
        this.createdBy = createdBy;
    }

    public void addUser(User user) {
        this.sharedUsers.add(user);
    }

    public void removeUser(User user) {
        this.sharedUsers.remove(user);
    }

    public void addBasketItem(BasketItem basketItem) {
        this.basket.add(basketItem);
    }

    public void removeBasketItem(BasketItem basketItem) {
        this.basket.remove(basketItem);
    }

    public Basket getBasket() {
        return this.basket;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

// TODO - REWRITE LAST COMMIT THAT CONTAINS WIP
}
