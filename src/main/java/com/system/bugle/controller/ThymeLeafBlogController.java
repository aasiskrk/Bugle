package com.system.bugle.controller;

import com.system.bugle.dto.BlogDto;
import com.system.bugle.dto.DepartmentDto;
import com.system.bugle.services.user_management.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

import java.io.IOException;

@Controller
@RequestMapping("/th-blogs")
public class ThymeLeafBlogController {

    private final BlogService blogService;

    public ThymeLeafBlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/create")
    public String getBlogForm(Model model) {
        model.addAttribute("blogDto", new BlogDto());
        return "blogs/newblog.html";
    }

//    @PostMapping("save")
//    public String saveBlog(@Valid BlogDto blogDto) {
//        blogService.saveBlog(blogDto);
//        return "data saved";
//    }
@PostMapping("/save")
public String saveBlog(@Valid BlogDto blogDto) throws IOException {
    BlogService.saveBlog(blogDto);
    return "redirect:/th-blogs/create";
}
    @GetMapping("/list")
    public String getBlogList(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "blog/list.html";
    }
}