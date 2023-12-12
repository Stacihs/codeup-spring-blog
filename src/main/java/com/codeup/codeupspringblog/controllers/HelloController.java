package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.swing.*;
import java.time.LocalDateTime;

@Controller
public class HelloController {


//    @GetMapping(path = "/hello/{personName}")
//    @ResponseBody
//    public String hello(@PathVariable String personName) {
//        return "Hello " + personName;
//    }
//
//    @GetMapping(path = "hello-msg/{personName}", produces = "application/json")
//    @ResponseBody
//    public String helloMessage(@PathVariable String personName) {
//        return String.format("Hello from JSON! %s %s", personName, LocalDateTime.now());
//    }


    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}