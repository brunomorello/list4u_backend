package br.com.l4u.shoppinglist.api.shoppinglist.model;

import br.com.l4u.shoppinglist.api.item.model.Item;
import br.com.l4u.shoppinglist.api.user.model.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ShoppingList {
    private String id;
    private String name;
    private User createdBy;
    private List<User> sharedUsers;
    private Basket basket;
}
