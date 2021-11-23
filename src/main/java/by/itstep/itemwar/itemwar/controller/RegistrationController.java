package by.itstep.itemwar.itemwar.controller;
//
//import by.itstep.itemwar.itemwar.dao.model.enums.Role;
import by.itstep.itemwar.itemwar.dao.model.User;
import by.itstep.itemwar.itemwar.service.InventoryService;
import by.itstep.itemwar.itemwar.service.ItemService;
import by.itstep.itemwar.itemwar.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final InventoryService inventoryService;


    public RegistrationController(UserService userService,
                                  InventoryService inventoryService) {
        this.userService = userService;
        this.inventoryService = inventoryService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userService.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.put("message", "User exist!");
            return "registration";
        }
        userService.setActive(user);
        userService.setStartMoney(user);
//        user.setRoles(Collections.singleton(Role.USER));
        inventoryService.createInventories();
        userService.save(user);
        return "redirect:/login";
    }
}
