package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @GetMapping("/signup")
    public String showSignUpForm(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam(name="email") String email, Model model){
        model.addAttribute("email", email);
        return "signup";
    }

}
