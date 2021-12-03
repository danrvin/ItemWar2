package by.itstep.itemwar.itemwar.controller.restController;

import by.itstep.itemwar.itemwar.dao.model.User;
import by.itstep.itemwar.itemwar.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

    private final UserService userService;

    public LoginRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/loginUser")
    public String loginUser(@RequestBody User user) {
        User user1 = userService.findByUsername(user.getUsername());
        System.out.println(user1.getUsername());
        if (user1.getUsername() != null) {
            return "profile.html";
        }
        return "login.html";
    }
}
