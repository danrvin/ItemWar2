package by.itstep.itemwar.itemwar.service;

import by.itstep.itemwar.itemwar.dao.model.Inventory;
import by.itstep.itemwar.itemwar.dao.model.User;

public interface InventoryService {

    void create(String name, User user);
    void save(Inventory inventory);
    Iterable<Inventory> findAll();
    Inventory findInventoryById(Long id);

    Inventory findByAuthor(User user);

    void setAuthor(Inventory inventory, User user);


    void deleteAuthor(Inventory inventory);


    void createInventories();

    void deleteIfNull(Inventory inventory);
}
