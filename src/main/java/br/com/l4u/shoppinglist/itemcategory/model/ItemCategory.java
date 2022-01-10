package br.com.l4u.shoppinglist.itemcategory.model;

import br.com.l4u.itemcategory.UnitMeasurement;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ItemCategory {
    private String id;
    private String name;
    private UnitMeasurement unitMeasurement;
}
