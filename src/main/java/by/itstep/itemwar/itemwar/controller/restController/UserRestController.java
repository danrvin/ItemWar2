package by.itstep.itemwar.itemwar.controller.restController;

import by.itstep.itemwar.itemwar.dao.model.User;
import by.itstep.itemwar.itemwar.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> list() {
        return userService.findAll();
    }
//
//    @GetMapping("{id}")
//    public User getOne(@PathVariable Long id) {
//        return userService.getOne(id);
//    }
//
    @PostMapping("/user")
    //public User create(@RequestBody User user) {
    public Long create(@RequestBody String str1) {
        System.out.println(str1);

        /*
        String nameStr =str1.split(",")[0];
        String passStr =str1.split(",")[1];


        nameStr = nameStr.split(":")[1];
        passStr = passStr.split(":")[1];

        int index = nameStr.indexOf("\"");
        int indexLast =nameStr.indexOf("\"",index + 1);
        nameStr = nameStr.substring(index+1,indexLast);

        index = passStr.indexOf("\"");
        indexLast =passStr.indexOf("\"",index + 1);
        passStr = passStr.substring(index+1,indexLast);
        */
        String nameStr =str1.split("#")[0];
        String passStr =str1.split("#")[1];





        System.out.println("*"+nameStr+"*"+passStr+"*");

        User user = new User();
        user.setUsername(nameStr);
        user.setPassword(passStr);
        user = userService.save(user);


//        int userId = Integer.parseInt(str1.substring(index,indexLast));
        

        return user.getId();
    }

    @GetMapping("/index.html")
    public File getStart() {
        File file = new File("templates/adminUser.html");
        return file;
    }

}
