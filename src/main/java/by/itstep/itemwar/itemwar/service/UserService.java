package by.itstep.itemwar.itemwar.service;

import by.itstep.itemwar.itemwar.dao.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User loadUserByUsername(String username);

    User findByUsername(String name);

    User save(User user);

    void setInventoryFalse(User user);

    void setInventoryTrue(User user);

    void setActive(User user);

    void setStartMoney(User user);

    void userSetMoneyFromItem(User user, Long id);

    void userRemoveMoneyFromInventory(User user, Long id);

    Iterable<User> findAll();

    User getOne(Long id);

    List<User> users();
}
