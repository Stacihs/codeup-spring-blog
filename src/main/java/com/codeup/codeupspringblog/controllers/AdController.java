package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/ads", "/ads/"})
public class AdController {

    Ad ad = new Ad("Amazing new product!", "The everything thing will solve all your problems! It will clean your floors, wash your dishes, cook your dinner, and walk your dog!");
    Ad ad2 = new Ad("Latest flying car", "This new flying car will take off above traffic and save you time on your morning commute! No pilot license required!");
    Ad ad3 = new Ad("Sunshine in a bottle", "Captured sunlight in a convenient recyclable bottle for all your natural lighting needs!");
    List<Ad> ads = new ArrayList<>(List.of(ad, ad2, ad3));

    @GetMapping({"", "/"})
    public String showAllAds(Model model) {
        model.addAttribute("ads", ads);
        return "/ads/index";
    }

    @GetMapping({"/create", "/create/"})
    public String showCreateAdForm() {
        return "/ads/create";
    }

    @PostMapping({"/create", "/create/"})
    public String handleAdSubmission(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description) {
        ads.add(new Ad(title, description));
        return "redirect:/ads";
    }

}