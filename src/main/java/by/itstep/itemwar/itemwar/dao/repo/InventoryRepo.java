package by.itstep.itemwar.itemwar.dao.repo;

import by.itstep.itemwar.itemwar.dao.model.Inventory;
import by.itstep.itemwar.itemwar.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory, Long> {
    Inventory findByAuthor(User user);
    Inventory findInventoryById(Long id);
}
