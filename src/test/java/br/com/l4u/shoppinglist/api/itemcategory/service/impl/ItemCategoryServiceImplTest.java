package br.com.l4u.shoppinglist.api.itemcategory.service.impl;

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
        ItemCategory itemCategory = service.createItemCategory(new ItemCategory(null, "Drinks"));

        assertNotNull(itemCategory.getId(), "ID must not be null");
        assertEquals("Drinks", itemCategory.getName(), "Names must be equals");
    }

    @Test
    void updateItemCategory() {
        ItemCategory itemCategory = service.listAllItemCategories().get(0);
        itemCategory.setName("Test");

        ItemCategory itemCategoryUpdated = service.updateItemCategory(itemCategory);

        assertNotNull(itemCategoryUpdated.getId(), "ID must not be null");
        assertEquals("Test", itemCategoryUpdated.getName(), "Item Category Name must be equals");
    }
}