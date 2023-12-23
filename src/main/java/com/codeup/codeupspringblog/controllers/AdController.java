package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.dao.AdDao;
import com.codeup.codeupspringblog.dao.UserRepository;
import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/ads", "/ads/"})
public class AdController {

    private final AdDao adDao;
    private final UserRepository userDao;

    public AdController(AdDao adDao, UserRepository userDao) {
        this.adDao = adDao;
        this.userDao = userDao;
    }


    @GetMapping({"", "/"})
    public String showAllAds(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "/ads/index";
    }

    @GetMapping({"/{id}", "/{id}/"})
    public String showOneAd(@PathVariable long id, Model model) {
        Ad ad;
        if (adDao.findById(id).isPresent()) {
            ad = adDao.findById(id).get();
        } else {
            ad = new Ad("Ad not found", "");
        }
        model.addAttribute(ad);
        return "/ads/show";
    }

    @GetMapping({"/create", "/create/"})
    public String showCreateAdForm() {
        return "/ads/create";
    }

    @PostMapping({"/create", "/create/"})
    public String handleAdSubmission(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description) {
        User user = userDao.findUserById(1L);
        adDao.save(new Ad(title, description));
        return "redirect:/ads";
    }

}