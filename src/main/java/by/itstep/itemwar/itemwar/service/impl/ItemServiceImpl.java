package by.itstep.itemwar.itemwar.service.impl;

import by.itstep.itemwar.itemwar.dao.model.Inventory;
import by.itstep.itemwar.itemwar.dao.model.Item;
import by.itstep.itemwar.itemwar.dao.repo.InventoryRepo;
import by.itstep.itemwar.itemwar.dao.repo.ItemRepo;
import by.itstep.itemwar.itemwar.dao.repo.UserRepo;
import by.itstep.itemwar.itemwar.service.ItemService;
import by.itstep.itemwar.itemwar.service.exceptions.NotFoundItemException;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;

    public ItemServiceImpl(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public Iterable<Item> findAllByInventory(Inventory inventory) {
        return itemRepo.findAllByInventory(inventory);
    }


    @Override
    public void deleteItem(Item item) {

        itemRepo.delete(item);
    }

    @Override
    public Item findItemById(Long id) {
        Item item = itemRepo.findItemById(id);
        if (item != null) {
            return item;
        } else {
            throw new NotFoundItemException("error item id");
        }
    }

    @Override
    public void createItemsFromInventory(Inventory inventory) {
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * 5) + 1;
            if (random == 1) {
                Item sword = new Item();
                sword.setName("Sword");
                sword.setDescription("");
                sword.setInventory(inventory);
                sword.setPrise(20L);
                itemRepo.save(sword);
            }
            if (random == 2) {
                Item bow = new Item();
                bow.setName("Bow");
                bow.setDescription("");
                bow.setInventory(inventory);
                bow.setPrise(25L);
                itemRepo.save(bow);
            }
            if (random == 3) {
                Item shield = new Item();
                shield.setName("shield");
                shield.setDescription("");
                shield.setInventory(inventory);
                shield.setPrise(45L);
                itemRepo.save(shield);
            }
            if (random == 4) {
                Item staff = new Item();
                staff.setName("staff");
                staff.setDescription("");
                staff.setInventory(inventory);
                staff.setPrise(100L);
                itemRepo.save(staff);
            }
        }
    }
}
