package br.com.l4u.shoppinglist.api.shoppinglist.model;

import br.com.l4u.shoppinglist.api.item.model.Item;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Basket {
    private Set<BasketItem> basketItems;

    protected Basket() {
        this.basketItems = new HashSet<>();
    }

    protected void add(BasketItem basketItem) {
        this.basketItems.add(basketItem);
    }

    protected void remove(BasketItem basketItem) {
        this.basketItems.remove(basketItem);
    }

    protected void empty() {
        this.basketItems.clear();
    }
}
