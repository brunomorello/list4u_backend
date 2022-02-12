package br.com.l4u.shoppinglist.api.itemcategory.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemCategoryTest {

    ItemCategory itemCategory;

    @BeforeEach
    void setup() {
        itemCategory = new ItemCategory("1", "Drinks");
    }

    @Test
    void testGetters() {
        assertEquals("1", itemCategory.getId(), "ID must be 1");
        assertEquals("Drinks", itemCategory.getName(), "Name must be Drinks");
    }

    @Test
    void testSetters() {
        itemCategory.setId("2");
        itemCategory.setName("Bakery");

        assertEquals("2", itemCategory.getId(), "ID must be 2");
        assertEquals("Bakery", itemCategory.getName(), "Name must be Bakery");
    }
}