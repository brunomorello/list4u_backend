package br.com.l4u.shoppinglist.api.item.repository.utils;

import br.com.l4u.itemcategory.UnitMeasurement;
import br.com.l4u.shoppinglist.api.item.model.Item;
import br.com.l4u.shoppinglist.api.item.repository.ItemRepository;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;
import br.com.l4u.shoppinglist.shared.exceptions.ResourceNotFoundException;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ItemFakeRepository implements ItemRepository {

    private List<Item> items = new ArrayList<>();
    private Faker faker = new Faker();

    public ItemFakeRepository() {
        ItemCategory itemCategory = new ItemCategory("3", "Test", UnitMeasurement.KILOGRAM);

        items.add(
            new Item(
                "1",
                faker.food().ingredient(),
                itemCategory
            )
        );

        items.add(new Item("2", "Test", itemCategory));
        items.add(new Item("3", "Teste", itemCategory));
        items.add(new Item("4", "testing", itemCategory));
    }

    @Override
    public Item save(Item item) throws IllegalArgumentException {
        Predicate<Item> itemIsPresent = item1 -> Objects.nonNull(item1);
        Predicate<Item> itemHasID = item1 -> Objects.nonNull(item1.getId());
        Predicate<Item> itemIsPresentAndHasID = itemIsPresent.and(itemHasID);
        Predicate<Item> itemIsPresentAndHasNoID = itemIsPresent.and(itemHasID.negate());

        if (itemIsPresentAndHasID.test(item)) {
            items.removeIf(item1 -> item1.getId().equals(item));
            items.add(item);
        }

        if (itemIsPresentAndHasNoID.test(item)) {
            item.setId(String.valueOf(faker.number().randomDigit()));
            items.add(item);
        }

        return item;
    }

    @Override
    public Item searchById(String id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with #" + id));
    }

    @Override
    public void delete(String id) {
        Item item = searchById(id);
        items.remove(item);
    }

    @Override
    public List<Item> listAll() {
        return items;
    }

    @Override
    public List<Item> searchByCategory(ItemCategory category) {
        return items.stream()
                .filter(item -> item.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> searchByNameLike(String name) {
        return items.stream()
                .filter(item -> item.getName().toLowerCase(Locale.ROOT).startsWith(name))
                .collect(Collectors.toList());
    }
}
