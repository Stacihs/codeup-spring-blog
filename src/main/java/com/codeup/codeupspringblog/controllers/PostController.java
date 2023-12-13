package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.dao.PostRepository;
import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }
    Post post1 = new Post("Post 1", "A bunch of words to add to first post");
    Post post2 = new Post("This is the Second Post", "Some more words to look at");
    List<Post> posts = new ArrayList<>(List.of(post1, post2));

//    @GetMapping("/posts")
//    @ResponseBody
//    public String posts() {
//        return "posts index page";
//    }

//    @GetMapping("/{id}")
//    @ResponseBody
//    public String post(@PathVariable String id) {
//        id = "view an individual post";
//        return id;
//    }

    @GetMapping("/{title}")
    public String showPost(@PathVariable String title, Model model) {
//        Post post3 = new Post("And another", "Some more words");
//        posts.add(post3);
        model.addAttribute("post", "Post 1");
        return "/posts/show";
    }

    @GetMapping("/index")
    public String viewAllPosts(Model model) {
        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping({"/create", "/create/"})
    public String createPst() {
            return "/posts/create";
    }

    @PostMapping({"/create", "/create/"})
    public String newPost(@RequestParam(name = "title") String title,
                          @RequestParam(name = "body") String body) {
        postDao.save(new Post(title, body));
        return "redirect:/posts";
    }

}
