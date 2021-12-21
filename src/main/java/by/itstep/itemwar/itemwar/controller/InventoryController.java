package by.itstep.itemwar.itemwar.controller;

import by.itstep.itemwar.itemwar.dao.model.Inventory;
import by.itstep.itemwar.itemwar.dao.model.User;
import by.itstep.itemwar.itemwar.service.InventoryService;
import by.itstep.itemwar.itemwar.service.UserService;
import by.itstep.itemwar.itemwar.service.impl.InventoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/inventories")
public class InventoryController {

    private final InventoryService inventoryService;
    private final UserService userService;

    public InventoryController(InventoryServiceImpl inventoryService, UserService userService) {
        this.inventoryService = inventoryService;
        this.userService = userService;
    }

    @GetMapping
    public String main(Map<String, Object> model, Principal principal) {
        Iterable<Inventory> inventories = inventoryService.findAll();
        User user = userService.findByEmail(principal.getName());
        Long money = user.getMoney();
        model.put("inventories", inventories);
        model.put("money", money);
        return "inventories";
    }

    @PostMapping("/buyButton")
    public String buyButton(
            @RequestParam Long invnetoryid,
            Principal principal,
            Map<String, Object> model
    ) {
        User user = userService.findByEmail(principal.getName());
        Inventory inventory = inventoryService.findInventoryById(invnetoryid);
        inventoryService.setAuthor(inventory, user);
//        userService.setInventoryTrue(user);
        userService.userRemoveMoneyFromInventory(user, invnetoryid);
        userService.save(user);
        inventoryService.save(inventory);
        model.put("inventories", inventory);
        return "redirect:/profile";
    }
}
