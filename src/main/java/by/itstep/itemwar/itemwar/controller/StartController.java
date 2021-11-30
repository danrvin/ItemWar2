package by.itstep.itemwar.itemwar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class StartController {
    @GetMapping("/")
    public String start(String name,Model model) {
        //model.addAttribute("name",name);
        return "index.html";
    }

    @GetMapping("test.js")
    public String request(String name,Model model) {
        //model.addAttribute("name",name);
        return "adminUser.js";
    }


/*
    public class StartController {
        @GetMapping("/")
        public String start(String name,Model model) {
            model.addAttribute("name",name);
            return "start";
        }
*/



}





