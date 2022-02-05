package br.com.l4u.shoppinglist.api.itemcategory.model;

import br.com.l4u.itemcategory.UnitMeasurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemCategoryTest {

    ItemCategory itemCategory;

    @BeforeEach
    void setup() {
        itemCategory = new ItemCategory("1", "Drinks", UnitMeasurement.LITER);
    }

    @Test
    void testGetters() {
        assertEquals("1", itemCategory.getId(), "ID must be 1");
        assertEquals("Drinks", itemCategory.getName(), "Name must be Drinks");
        assertEquals(UnitMeasurement.LITER, itemCategory.getUnitMeasurement(), "Unit of Measurement must be Liter");
    }

    @Test
    void testSetters() {
        itemCategory.setId("2");
        itemCategory.setName("Bakery");
        itemCategory.setUnitMeasurement(UnitMeasurement.KILOGRAM);

        assertEquals("2", itemCategory.getId(), "ID must be 2");
        assertEquals("Bakery", itemCategory.getName(), "Name must be Bakery");
        assertEquals(UnitMeasurement.KILOGRAM, itemCategory.getUnitMeasurement(), "Unit of Measurement must be KG");
    }
}