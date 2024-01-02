package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.dao.AdDao;
import com.codeup.codeupspringblog.dao.CategoryRepository;
import com.codeup.codeupspringblog.dao.UserRepository;
import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.models.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping({"/ads", "/ads/"})
public class AdController {

    private AdDao adDao;
    private UserRepository userDao;
    private CategoryRepository categoryDao;


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
    public String showCreateAdForm(Model model) {
        model.addAttribute("ad", new Ad());
        List<Category> categories = categoryDao.findAll();
        model.addAttribute("categories", categories);
        return "/ads/create";
    }

    @PostMapping({"/create", "/create/"})
    public String handleAdSubmission(@ModelAttribute Ad ad) {
        ad.setUser(userDao.findUserById(1L));
        adDao.save(ad);
        return "redirect:/ads";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Ad ad;
        if (adDao.findById(id).isPresent()) {
            ad = adDao.findById(id).get();
        } else {
            ad = null;
        }
        model.addAttribute("ad", ad);
        return "/ads/edit";
    }

    @PostMapping("/{id}/edit")
    public String editAd(@ModelAttribute Ad ad, @RequestParam long userId) {
        ad.setUser(userDao.findUserById((userId)));
        adDao.save(ad);
        return "redirect:/ads";
    }

}