package com.codeup.codeupspringblog.controllers;

import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
class PostController {
    Post post1 = new Post("Post 1", "A bunch of words to add to first post");
    Post post2 = new Post("This is the Second Post", "Some more words to look at");
    List<Post> posts = new ArrayList<>(List.of(post1, post2));

//    @GetMapping("/posts")
//    @ResponseBody
//    public String posts() {
//        return "posts index page";
//    }

    @GetMapping("/{id}")
    @ResponseBody
    public String post(@PathVariable String id) {
        id = "view an individual post";
        return id;
    }

    @GetMapping("/{title}")
    public String showPost(@PathVariable String title, Model model) {
        model.addAttribute("post", post1);
        return "/posts/show";
    }

    @GetMapping("/index")
    public String viewAllPosts(Model model) {
        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/create")
    @ResponseBody
    public String createPst() {
        return "view the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String newPost() {
        return "create new post";
    }

}
