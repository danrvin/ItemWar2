package by.itstep.itemwar.itemwar.controller;

import by.itstep.itemwar.itemwar.dao.model.User;
import by.itstep.itemwar.itemwar.dao.model.enums.Role;
import by.itstep.itemwar.itemwar.dao.model.enums.Status;
import by.itstep.itemwar.itemwar.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {

        return "registration";
    }

    @PostMapping("/registration")
    public String userRegistration(@RequestBody User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);
        userService.save(user);
        return "/rest/user";
    }
}
