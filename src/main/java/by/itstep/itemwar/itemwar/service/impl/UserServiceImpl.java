package by.itstep.itemwar.itemwar.service.impl;

import by.itstep.itemwar.itemwar.dao.model.Inventory;
import by.itstep.itemwar.itemwar.dao.model.Item;
import by.itstep.itemwar.itemwar.dao.model.User;
import by.itstep.itemwar.itemwar.dao.repo.InventoryRepo;
import by.itstep.itemwar.itemwar.dao.repo.ItemRepo;
import by.itstep.itemwar.itemwar.dao.repo.UserRepo;
import by.itstep.itemwar.itemwar.service.UserService;
import by.itstep.itemwar.itemwar.service.exceptions.NotEnoughMoneyException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;
    private final ItemRepo itemRepo;
    private final InventoryRepo inventoryRepo;

    public UserServiceImpl(UserRepo userRepo, ItemRepo itemRepo, InventoryRepo inventoryRepo) {
        this.userRepo = userRepo;
        this.itemRepo = itemRepo;
        this.inventoryRepo = inventoryRepo;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepo.findByUsername(username);
//    }

    @Override
    public User findByUsername(String name) {
        return userRepo.findByUsername(name);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void setInventoryFalse(User user) {
        user.setInventory(false);
    }

    @Override
    public void setInventoryTrue(User user) {
        user.setInventory(true);
    }

    @Override
    public void setActive(User user) {
        user.setActive(true);
    }

    @Override
    public void setStartMoney(User user) {
        user.setMoney(400L);
    }

    @Override
    public void userSetMoneyFromItem(User user, Long id) {
        Item item = itemRepo.findItemById(id);
        Long moneys = user.getMoney();
        Long prise = item.getPrise();
        Long wallet = moneys + prise;
        user.setMoney(wallet);
        userRepo.save(user);
    }

    @Override
    public void userRemoveMoneyFromInventory(User user, Long id) {
        Inventory inventory = inventoryRepo.findInventoryById(id);
        Long price = inventory.getPrice();
        Long moneys = user.getMoney();
        if (moneys >= price) {
            Long wallet = moneys - price;
            user.setMoney(wallet);
            userRepo.save(user);
        } else {
            throw new NotEnoughMoneyException("you dont have enough money");
        }
    }

    @Override
    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User getOne(Long id) {
        return userRepo.findUserById(id);
    }

    @Override
    public List<User> users() {
        return userRepo.findAll();
    }
}
