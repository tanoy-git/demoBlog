package com.example.demo;

import com.example.demo.posts.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.model.IModel;

@Controller
@RequestMapping("/test")
public class TestController {

    private final PostService postService;

    public TestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String get(Model model) {
        var result = postService.getAll();

        model.addAttribute("posts", result);

        return "index";
    }
}
