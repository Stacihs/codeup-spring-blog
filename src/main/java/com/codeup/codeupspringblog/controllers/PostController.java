package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.dao.PostRepository;
import com.codeup.codeupspringblog.dao.UserRepository;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@Controller
@RequestMapping("/posts")
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;


//    Post post1 = new Post("Post 1", "A bunch of words to add to first post");
//    Post post2 = new Post("This is the Second Post", "Some more words to look at");
//    List<Post> posts = new ArrayList<>(List.of(post1, post2));

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

    @GetMapping({"/{id}", "/{id}/"})
    public String showPost(@PathVariable long id, Model model) {
        Post post;
        if (postDao.findById(id).isPresent()) {
            post = postDao.findById(id).get();
        } else {
            post = new Post("No such post", "");
        }
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping({"/", ""})
    public String viewAllPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

    @GetMapping({"/create", "/create/"})
    public String createPostForm() {
        return "/posts/create";
    }

    @PostMapping({"/create", "/create/"})
    public String newPost(@RequestParam(name = "title") String title,
                          @RequestParam(name = "body") String body) {
        Post post = new Post(title, body);
        User user = userDao.findUserById(1L);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

}
