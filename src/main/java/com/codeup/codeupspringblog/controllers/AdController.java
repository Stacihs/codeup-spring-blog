package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.dao.AdDao;
import com.codeup.codeupspringblog.dao.CategoryRepository;
import com.codeup.codeupspringblog.dao.UserRepository;
import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.models.Category;
import com.codeup.codeupspringblog.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
        List<Category> categories = categoryDao.findAll();
        categories.sort(Comparator.comparing(Category::getName));
        model.addAttribute("categories", categories);
        return "/ads/create";
    }

    @PostMapping({"/create", "/create/"})
    public String handleAdSubmission(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description) {
        User user = userDao.findUserById(1L);
        Ad ad = new Ad(title, description, user);
        Set<Category> categoryList = new Set<Category>();
        for (String category : categories){
            Category categoryFromDB = categoryDao.findCategoryByName(category);
            categoryList.add(categoryFromDB);
        }
        ad.setCategories(categoryList);
        adDao.save(new Ad(title, description));
        return "redirect:/ads";
    }

}