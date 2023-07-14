package com.system.bugle.controller;

import com.system.bugle.dto.BlogDto;
import com.system.bugle.dto.DepartmentDto;
import com.system.bugle.entity.user_management.Blog;
import com.system.bugle.pojo.user_management.BlogPojo;
import com.system.bugle.pojo.user_management.UserPojo;
import com.system.bugle.services.user_management.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    @PostMapping("save")
    public String saveBlog(@Valid BlogDto blogDto, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        // Handle validation errors
        return "blogs/newblog.html";
    }

    blogService.saveBlog(blogDto);
    return "redirect:/th-blogs/create";
}

    @GetMapping("/fetchById/{id}")
    public String showBlogDetails(@PathVariable Long id, Model model) {
        Optional<Blog> blogOptional = blogService.fetchById(id);
        if (blogOptional.isPresent()) {
            model.addAttribute("blogs", blogOptional.get());
            return "blog_page.html";
        } else {
            // Handle case when blog is not found
            model.addAttribute("errorMessage", "Blog not found");
        }
        return "blogs/blog_page.html";
    }

    @GetMapping("/getAll")
    public String getAllBlogs(Model model) {
        List<Blog> blogs = blogService.getAllBlogs();
        model.addAttribute("blogs", blogs);
        return "blogs/blogs_page.html";
    }

    @GetMapping("/list")
    public String getBlogList(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "blog/list.html";
    }
}
