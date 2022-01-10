package br.com.l4u.shoppinglist.itemcategory.model;

import br.com.l4u.itemcategory.UnitMeasurement;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ItemCategory {
    private UUID id;
    private String name;
    private UnitMeasurement unitMeasurement;
}
