package by.itstep.itemwar.itemwar.dao.repo;

import by.itstep.itemwar.itemwar.dao.model.Inventory;
import by.itstep.itemwar.itemwar.dao.model.Item;
import by.itstep.itemwar.itemwar.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Long> {
    List<Item> findAllByInventory(Inventory inventory);
    List<Item> findAllByInventoryOrderByPriseDesc(Inventory inventory);
    Item findItemById(Long id);
}
