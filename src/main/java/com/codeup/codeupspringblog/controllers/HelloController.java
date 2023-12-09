package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.time.LocalDateTime;

@Controller
class HelloController {

//    @RequestMapping(method = RequestMethod.GET, name = "/hello")
    @GetMapping(path = "/hello/{personName}")
    @ResponseBody
    public String hello(@PathVariable String personName) {
        return "Hello " + personName;
    }

    @GetMapping(path = "hello-msg/{personName}", produces = "application/json")
    @ResponseBody
    public String helloMessage(@PathVariable String personName) {
        return String.format("Hello from JSON! %s %s", personName, LocalDateTime.now());
    }
}