package br.com.l4u.shoppinglist.api.shoppinglist.model;

import br.com.l4u.shoppinglist.UnitMeasurement;
import br.com.l4u.shoppinglist.api.item.model.Item;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BasketItem {
    private Item item;
    private Double quantity;
    private Boolean pickedUp;
    private UnitMeasurement unitMeasurement;
    private LocalDateTime addedAt;
    private LocalDateTime updatedAt;
}
