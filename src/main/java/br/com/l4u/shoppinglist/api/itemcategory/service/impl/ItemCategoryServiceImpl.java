package br.com.l4u.shoppinglist.api.itemcategory.service.impl;

import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;
import br.com.l4u.shoppinglist.api.itemcategory.repository.ItemCategoryRepository;
import br.com.l4u.shoppinglist.api.itemcategory.service.ItemCategoryService;

import java.util.List;

public class ItemCategoryServiceImpl implements ItemCategoryService {

    ItemCategoryRepository repository;

    public ItemCategoryServiceImpl(ItemCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ItemCategory> listAllItemCategories() {
        return repository.listAll();
    }

    @Override
    public ItemCategory createItemCategory(ItemCategory itemCategory) {
        return repository.save(itemCategory);
    }

    @Override
    public ItemCategory updateItemCategory(ItemCategory itemCategory) {
        return repository.save(itemCategory);
    }
}
