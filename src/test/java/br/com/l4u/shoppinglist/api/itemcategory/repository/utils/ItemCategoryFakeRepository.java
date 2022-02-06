package br.com.l4u.shoppinglist.api.itemcategory.repository.utils;

import br.com.l4u.itemcategory.UnitMeasurement;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;
import br.com.l4u.shoppinglist.api.itemcategory.repository.ItemCategoryRepository;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ItemCategoryFakeRepository implements ItemCategoryRepository {

    private List<ItemCategory> itemCategories = new ArrayList<>();
    private Faker faker = new Faker();

    public ItemCategoryFakeRepository() {
        itemCategories.add(
            new ItemCategory(
                String.valueOf(faker.number().randomDigit()),
                faker.food().ingredient()));
    }

    @Override
    public ItemCategory save(ItemCategory itemCategory) throws IllegalArgumentException {
        Predicate<ItemCategory> itemCategoryIsPresent = itemCategory1 -> itemCategory1 != null ? true : false;
        Predicate<ItemCategory> itemCategoryHasID = itemCategory1 -> itemCategory1.getId() != null ? true : false;
        Predicate<ItemCategory> itemCategoryIsPresentAndHasID = itemCategoryIsPresent.and(itemCategoryHasID);
        Predicate<ItemCategory> itemCategoryIsPresentAndHasNoID = itemCategoryIsPresent.and(itemCategoryHasID.negate());

        if (itemCategoryIsPresentAndHasID.test(itemCategory)) {
            itemCategories.remove(itemCategory);
            itemCategories.add(itemCategory);
        }

        if (itemCategoryIsPresentAndHasNoID.test(itemCategory))
            itemCategory.setId(String.valueOf(faker.number().randomDigit()));
            itemCategories.add(itemCategory);

        return itemCategory;
    }

    @Override
    public List<ItemCategory> listAll() {
        return itemCategories;
    }
}
