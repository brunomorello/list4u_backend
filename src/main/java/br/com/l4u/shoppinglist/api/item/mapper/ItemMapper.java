package br.com.l4u.shoppinglist.api.item.mapper;

import br.com.l4u.item.ItemRequest;
import br.com.l4u.item.ItemType;
import br.com.l4u.item.ItemUpdateRequest;
import br.com.l4u.shoppinglist.api.item.model.Item;
import org.bson.Document;

public interface ItemMapper {
    public ItemType parse(Item item);
    public Item toModel(ItemUpdateRequest request);
    public Item toModel(ItemRequest request);
    public Item documentToModel(Document document);
}
