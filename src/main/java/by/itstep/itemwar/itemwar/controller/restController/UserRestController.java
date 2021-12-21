package by.itstep.itemwar.itemwar.controller.restController;

import by.itstep.itemwar.itemwar.dao.model.Item;
import by.itstep.itemwar.itemwar.dao.model.User;
import by.itstep.itemwar.itemwar.service.ItemService;
import by.itstep.itemwar.itemwar.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PreAuthorize(value = "hasAuthority('users:read')")
    public User findById(@PathVariable Long id) {
        return userService.findByUserId(id);
    }

}
