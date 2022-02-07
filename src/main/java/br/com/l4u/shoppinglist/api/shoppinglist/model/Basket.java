package br.com.l4u.shoppinglist.api.shoppinglist.model;

import br.com.l4u.shoppinglist.api.item.model.Item;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Basket {
    private List<BasketItem> basketItems;
}
