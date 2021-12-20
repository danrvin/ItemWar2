package by.itstep.itemwar.itemwar.controller.restController;

import by.itstep.itemwar.itemwar.dao.model.Item;
import by.itstep.itemwar.itemwar.dao.model.User;
import by.itstep.itemwar.itemwar.service.ItemService;
import by.itstep.itemwar.itemwar.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {

    private final ItemService itemService;
    private final UserService userService;

    public UserRestController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    public Item findById(@PathVariable Long id) {
        return itemService.findItemById(id);

    }

}
