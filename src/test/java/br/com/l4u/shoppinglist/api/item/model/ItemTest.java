package br.com.l4u.shoppinglist.api.item.model;

import br.com.l4u.itemcategory.UnitMeasurement;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Item item;

    @Test
    void test_item_constructor_with_valid_values() {
        ItemCategory pastaCategory = new ItemCategory("123", "Pasta", UnitMeasurement.KILOGRAM);
        item = new Item("123", "Spaghetti", pastaCategory);

        assertEquals("123", item.getId(), "ID must be Equals - value ex: 123");
        assertEquals("Spaghetti", item.getName(), "Name must be Equals - value ex: Spaghetti");
        assertEquals("Pasta", item.getCategory().getName(), "Item Category must be Equals - value ex: Pasta");
    }

    @Test
    void test_null_item() {
        assertNull(item);
    }

    @Test
    void test_item_getters_setters() {
        item = new Item(null, null, null);
        item.setId("333");
        item.setName("Heineken");

        ItemCategory beer = new ItemCategory("444", "Beer", UnitMeasurement.LITER);
        item.setCategory(beer);

        assertEquals("333", item.getId(), "ID must be 333");
        assertEquals("Heineken", item.getName(), "Name must be Heineken");
        assertEquals(beer, item.getCategory(), "Category must be Beer");
    }

}