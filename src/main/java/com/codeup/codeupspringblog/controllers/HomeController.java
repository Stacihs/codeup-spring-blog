package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//class HomeController {
//    @GetMapping("/home")
//    @ResponseBody
//    public String home() {
//        return "This is the landing page!";
//    }
//}
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String welcome() {
        return "home";
    }
}