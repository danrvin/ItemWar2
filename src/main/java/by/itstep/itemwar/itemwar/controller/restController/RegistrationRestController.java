package by.itstep.itemwar.itemwar.controller.restController;

import by.itstep.itemwar.itemwar.dao.model.User;
import by.itstep.itemwar.itemwar.service.InventoryService;
import by.itstep.itemwar.itemwar.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationRestController {

    private final UserService userService;
    private final InventoryService inventoryService;

    public RegistrationRestController(UserService userService, InventoryService inventoryService) {
        this.userService = userService;
        this.inventoryService = inventoryService;
    }

    @PostMapping("/restRegistration")
    public String registration(@RequestBody User user) {

        User user1 = userService.save(user);
        userService.setActive(user1);
        userService.setStartMoney(user1);
        inventoryService.createInventories();
        if (user1.getUsername() != null) {
            return "login.html";
        }
        return "registration.html";
    }
}
