package by.itstep.itemwar.itemwar.controller;

import by.itstep.itemwar.itemwar.dao.model.Inventory;
import by.itstep.itemwar.itemwar.dao.model.User;
import by.itstep.itemwar.itemwar.service.InventoryService;
import by.itstep.itemwar.itemwar.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Map;

@Controller
public class ProfileController {

    private final InventoryService inventoryService;
    private final UserService userService;

    public ProfileController(InventoryService inventoryService,
                             UserService userService) {
        this.inventoryService = inventoryService;
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Map<String, Object> model) {
        User user = userService.findByUsername(principal.getName());
        Inventory inventory = inventoryService.findByAuthor(user);
        Long money = user.getMoney();
        model.put("inventory", inventory);
        model.put("money", money);
        return "profile";

    }

    @PostMapping("/profile/delete")
    public String delete(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Inventory inventory = inventoryService.findByAuthor(user);
        inventoryService.deleteAuthor(inventory);
        inventoryService.deleteIfNull(inventory);
//        userService.setInventoryFalse(user);
        userService.save(user);
        inventoryService.save(inventory);
        return "profile";
    }

    @PostMapping("/profile/choose")
    public String choose(Principal principal, Map<String, Object> model) {
        User user = userService.findByUsername(principal.getName());
//        if (user.isInventory()) {
//            model.put("message", "Inventory is already in use!!");
//            return "profile";
//        }
        return "redirect:/inventories";
    }
}
