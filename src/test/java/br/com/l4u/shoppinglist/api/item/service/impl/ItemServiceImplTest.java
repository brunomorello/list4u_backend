package br.com.l4u.shoppinglist.api.item.service.impl;

import br.com.l4u.itemcategory.UnitMeasurement;
import br.com.l4u.shoppinglist.api.item.model.Item;
import br.com.l4u.shoppinglist.api.item.repository.utils.ItemFakeRepository;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;
import br.com.l4u.shoppinglist.shared.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceImplTest {

    private static ItemServiceImpl service;
    private ItemCategory itemCategory = new ItemCategory("3", "Test");

    @BeforeAll
    static void setup() {
        service = new ItemServiceImpl(new ItemFakeRepository());
    }

    @Test
    void create() {
        ItemCategory drinksCategory = new ItemCategory("33", "Drinks");
        Item item = new Item(null, "Heineken", drinksCategory);

        Item itemCreated = service.create(item);

        assertNotNull(itemCreated.getId(), "ID must not be null");
        assertEquals("Heineken", itemCreated.getName(), "values must be equals");
        assertEquals(drinksCategory, itemCreated.getCategory(), "category must be equals");
    }

    @Test
    void update() {
        Item bread = service.update(new Item(
                "1",
                "Bread",
                itemCategory
        ));

        assertEquals("1", bread.getId(), "ID must be equals");
        assertEquals("Bread", bread.getName(), "Name must be equals");
        assertEquals(itemCategory, bread.getCategory(), "Category must be equals");
    }

    @Test
    void delete() {
        service.delete(new Item("1", "Bread", itemCategory));
        assertThrows(ResourceNotFoundException.class, () -> service.searchById("1"));
    }

    @Test
    void searchById() {
        Item itemFound = service.searchById("1").get();

        assertEquals("1", itemFound.getId(), "ID must be equals");
        assertNotNull(itemFound.getName(), "Name must be equals");
        assertEquals(itemCategory, itemFound.getCategory(), "Category must be equals");
    }

    @Test
    void searchByIdNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> service.searchById("-10"));
    }

    @Test
    void searchByNameLike() {
        List<Item> itemList = service.searchByNameLike("test");

        assertEquals(3, itemList.size(), "List must have 3 values");
    }

    @Test
    void searchByNameLikeNotFound() {
        List<Item> itemList = service.searchByNameLike("hello");
        assertEquals(0, itemList.size(), "List must be empty");
    }

    @Test
    void searchByCategory() {
        List<Item> itemList = service.searchByCategory(itemCategory);
        assertNotEquals(0, itemList.size(), "List must not be empty");
    }

    @Test
    void searchByCategoryNotFound() {
        List<Item> itemList = service.searchByCategory(new ItemCategory("1", "blabla"));
        assertEquals(0, itemList.size(), "List must be empty");
    }

    @Test
    void listAll() {
        service.listAll().stream()
                        .forEach(System.out::println);
        assertNotEquals(0, service.listAll().size(), "List All must not be empty");
    }
}