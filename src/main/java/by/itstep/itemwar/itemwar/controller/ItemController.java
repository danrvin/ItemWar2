package by.itstep.itemwar.itemwar.controller;

import by.itstep.itemwar.itemwar.dao.model.Inventory;
import by.itstep.itemwar.itemwar.dao.model.Item;
import by.itstep.itemwar.itemwar.dao.model.User;
import by.itstep.itemwar.itemwar.service.InventoryService;
import by.itstep.itemwar.itemwar.service.ItemService;
import by.itstep.itemwar.itemwar.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Controller
public class ItemController {

    private final UserService userService;
    private final InventoryService inventoryService;
    private final ItemService itemService;

    public ItemController(UserService userService, InventoryService inventoryService, ItemService itemService) {
        this.userService = userService;
        this.inventoryService = inventoryService;
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public String findByInventory(
            Map<String, Object> model,
            Principal principal
    ) {
        User user = userService.findByUsername(principal.getName());
        Inventory inventory = inventoryService.findByAuthor(user);
        Iterable<Item> items = itemService.findAllByInventory(inventory);
        model.put("items", items);
        return "items";
    }

    @PostMapping("/items")
    public String findAllItem(
            @RequestParam Long id,
            Map<String, Object> model,
            Principal principal
    ) {
        User user = userService.findByUsername(principal.getName());
        Inventory inventory = inventoryService.findByAuthor(user);
        Item item = itemService.findItemById(id);
        userService.userSetMoneyFromItem(user,id);
        itemService.deleteItem(item);
        Iterable<Item> items = itemService.findAllByInventory(inventory);
        model.put("items", items);
        return "items";
    }
}
