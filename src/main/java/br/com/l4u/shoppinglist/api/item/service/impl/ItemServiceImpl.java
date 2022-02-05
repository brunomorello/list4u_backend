package br.com.l4u.shoppinglist.api.item.service.impl;

import br.com.l4u.shoppinglist.api.item.model.Item;
import br.com.l4u.shoppinglist.api.item.repository.ItemRepository;
import br.com.l4u.shoppinglist.api.item.service.ItemService;
import br.com.l4u.shoppinglist.api.itemcategory.model.ItemCategory;

import java.util.List;
import java.util.Optional;

public class ItemServiceImpl implements ItemService {

    private ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Item create(Item item) {
        return repository.save(item);
    }

    @Override
    public Item update(Item item) {
        return repository.save(item);
    }

    @Override
    public void delete(Item item) {
        repository.delete(item.getId());
    }

    @Override
    public List<Item> listAll() {
        return repository.listAll();
    }

    @Override
    public Optional<Item> searchById(String id) {
        return Optional.ofNullable(repository.searchById(id));
    }

    @Override
    public List<Item> searchByNameLike(String name) {
        return repository.searchByNameLike(name);
    }

    @Override
    public List<Item> searchByCategory(ItemCategory itemCategory) {
        return repository.searchByCategory(itemCategory);
    }
}
