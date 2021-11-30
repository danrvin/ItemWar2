package by.itstep.itemwar.itemwar.service;

import by.itstep.itemwar.itemwar.dao.model.Inventory;
import by.itstep.itemwar.itemwar.dao.model.Item;

public interface ItemService {
    Iterable<Item> findAllByInventory(Inventory inventory);
    void deleteItem(Item item);



    Item findItemById(Long id);

    void save(Item item);

    void createItemsFromInventory(Inventory inventory);
}
