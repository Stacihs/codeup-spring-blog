package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.dao.UserRepository;
import com.codeup.codeupspringblog.models.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
public class UserController {

    private UserRepository userDao;

    @GetMapping("/profile")
    public String userProfile(){
        return "profile";
    }

    @PostMapping("/profile")
    public String changeProfile(@RequestParam(name = "email") String email){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findUserById(loggedInUser.getId());
        user.setEmail(email);
        userDao.save(user);
        loggedInUser.setEmail(email);
        return "redirect:/profile";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userDao.save(user);
        return "redirect:/login";
    }
}
