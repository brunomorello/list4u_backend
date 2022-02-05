package br.com.l4u.shoppinglist.api.itemcategory.service.impl;

import br.com.l4u.itemcategory.UnitMeasurement;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;
import br.com.l4u.shoppinglist.api.itemcategory.repository.utils.ItemCategoryFakeRepository;
import br.com.l4u.shoppinglist.api.itemcategory.service.ItemCategoryService;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemCategoryServiceImplTest {

    private static ItemCategoryService service;

    @BeforeAll
    static void setup() {
        service = new ItemCategoryServiceImpl(new ItemCategoryFakeRepository());
    }

    @Test
    void listAllItemCategories() {
        service.listAllItemCategories()
                .stream()
                .forEach(System.out::println);
        assertNotEquals(0, service.listAllItemCategories().size());
    }

    @Test
    void createItemCategory() {
        ItemCategory itemCategory = service.createItemCategory(new ItemCategory(null, "Drinks", UnitMeasurement.MILLILITER));

        assertNotNull(itemCategory.getId(), "ID must not be null");
        assertEquals("Drinks", itemCategory.getName(), "Names must be equals");
        assertEquals(UnitMeasurement.MILLILITER, itemCategory.getUnitMeasurement(), "Item Category Unit of Measurement must be equals");
    }

    @Test
    void updateItemCategory() {
        ItemCategory itemCategory = service.listAllItemCategories().get(0);

        itemCategory.setName("Test");
        itemCategory.setUnitMeasurement(UnitMeasurement.GRAM);

        ItemCategory itemCategoryUpdated = service.updateItemCategory(itemCategory);

        assertNotNull(itemCategoryUpdated.getId(), "ID must not be null");
        assertEquals("Test", itemCategoryUpdated.getName(), "Item Category Name must be equals");
        assertEquals(UnitMeasurement.GRAM, itemCategoryUpdated.getUnitMeasurement(), "Item Category Unit of Measurement must be equals");
    }
}