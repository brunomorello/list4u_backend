package br.com.l4u.shoppinglist.api.shoppinglist.model;

import br.com.l4u.shoppinglist.UnitMeasurement;
import br.com.l4u.shoppinglist.api.item.model.Item;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;
import br.com.l4u.shoppinglist.api.user.model.User;
import br.com.l4u.user.Gender;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {

    private static ShoppingList shoppingList;

    @BeforeAll
    static void setup() {
        User user = new User();
        user.setId("123");
        user.setFirstName("Foo");
        user.setLastName("Bar");
        user.setDisplayName("Foob");
        user.setGender(Gender.OTHERS);
        user.setBirthday(LocalDate.of(1996, 1, 10));
        shoppingList = new ShoppingList(user);
        shoppingList.setName("Testing shopping list");

        User user2 = new User();
        user2.setId("333");
        user2.setFirstName("Bar");
        user2.setLastName("Foo");
        user2.setDisplayName("BarF");
        user2.setGender(Gender.OTHERS);
        user2.setBirthday(LocalDate.of(1996, 1, 10));
        shoppingList.addUser(user2);
    }

    @Test
    void addUser() {
        User user = new User();
        user.setId("333");
        user.setFirstName("Bar");
        user.setLastName("Foo");
        user.setDisplayName("BarF");
        user.setGender(Gender.OTHERS);
        user.setBirthday(LocalDate.of(1996, 1, 10));
        shoppingList.addUser(user);

        Optional<User> optionalUser = shoppingList.getSharedUsers().stream()
                .filter(user1 -> user1.equals(user))
                .findAny();

        assertTrue(optionalUser.isPresent(), "Added User must be on shared list");
    }

    @Test
    void removeUser() {
        User user = new User();
        user.setId("333");
        user.setFirstName("Bar");
        user.setLastName("Foo");
        user.setDisplayName("BarF");
        user.setGender(Gender.OTHERS);
        user.setBirthday(LocalDate.of(1996, 1, 10));
        shoppingList.addUser(user);

        Optional<User> optionalUser = shoppingList.getSharedUsers().stream()
                .filter(user1 -> user1.equals(user))
                .findAny();

        assertTrue(optionalUser.isPresent(), "Added User must be on shared list");

        shoppingList.removeUser(user);

        optionalUser = shoppingList.getSharedUsers().stream()
                .filter(user1 -> user1.equals(user))
                .findAny();

        assertFalse(optionalUser.isPresent(), "User must not exists on shared list");
    }

    @Test
    void addBasketItem() {
        ItemCategory pastaCategory = new ItemCategory("123", "Pasta");
        Item item = new Item("123", "Spaghetti", pastaCategory);

        BasketItem basketItem = new BasketItem(
                item,
                Double.valueOf(2),
                Boolean.FALSE,
                UnitMeasurement.PACKAGE,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        shoppingList.addBasketItem(basketItem);

        Optional<BasketItem> basketItemOpt = shoppingList.getBasket().getBasketItems()
                .stream()
                .findFirst();

        assertTrue(basketItemOpt.isPresent(), "Basket Item has been added");
    }

    @Test
    void removeBasketItem() {
        ItemCategory pastaCategory = new ItemCategory("123", "Pasta");
        Item item = new Item("52", "Spaghetti", pastaCategory);

        BasketItem basketItem = new BasketItem(
                item,
                Double.valueOf(2),
                Boolean.FALSE,
                UnitMeasurement.PACKAGE,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        shoppingList.addBasketItem(basketItem);
        shoppingList.removeBasketItem(basketItem);

        Optional<BasketItem> basketItemOpt = shoppingList.getBasket().getBasketItems()
                .stream()
                .filter(basketItem1 -> basketItem1.equals(item))
                .findFirst();

        assertFalse(basketItemOpt.isPresent(), "Basket Item has been removed");
    }

    @Test
    void getSharedUsers() {
        assertNotEquals(0, shoppingList.getSharedUsers().size(), "Shared Users must have at least one user");
    }

    @Test
    void testShoppingListName() {
        assertEquals("Testing shopping list", shoppingList.getName());
    }
}