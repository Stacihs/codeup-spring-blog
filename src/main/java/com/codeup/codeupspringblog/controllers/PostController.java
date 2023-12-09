package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String post(@PathVariable String id) {
        id = "view an individual post";
        return id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPst() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    public String newPost(@RequestBody String newPost) {
        newPost = "create new post";
        return newPost;
    }
}
