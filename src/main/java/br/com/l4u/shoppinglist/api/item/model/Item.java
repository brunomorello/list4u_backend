package br.com.l4u.shoppinglist.api.item.model;

import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Item {
    private String id;
    private String name;
    private ItemCategory category;
}
