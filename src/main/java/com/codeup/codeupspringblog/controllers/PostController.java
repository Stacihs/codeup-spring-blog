package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.dao.AdDao;
import com.codeup.codeupspringblog.dao.PostRepository;
import com.codeup.codeupspringblog.dao.UserRepository;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
//import com.codeup.codeupspringblog.services.PostEmailService;
import com.codeup.codeupspringblog.services.PostEmailService;
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
    private PostEmailService emailService;



    @GetMapping({"/", ""})
    public String viewAllPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

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

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Post post;
        if (postDao.findById(id).isPresent()) {
            post = postDao.findById(id).get();
        } else {
            post = null;
        }
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@ModelAttribute Post post, @RequestParam long userId) {
        post.setUser(userDao.findUserById(userId));
        postDao.save(post);
        emailService.prepareAndSend(post, post.getTitle(), post.getBody());
        return "redirect:/posts";
    }

}
