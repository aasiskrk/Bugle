package com.system.bugle.controller;

import com.system.bugle.dto.BlogDto;
import com.system.bugle.entity.user_management.Blog;
import com.system.bugle.entity.user_management.User;
import com.system.bugle.pojo.user_management.UserPojo;
import com.system.bugle.repo.user_management.UserRepo;
import com.system.bugle.services.user_management.BlogService;
import com.system.bugle.services.user_management.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

import java.util.List;
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
    public String saveBlog(@Valid BlogDto blogDto, BindingResult bindingResult, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return "blogs/newblog.html";
        }
        String uemail= authentication.getName();

        blogService.saveBlog(blogDto, uemail);
        return "redirect:/th-blogs/create";
    }

    @GetMapping("/fetchById/{id}")
    public String showBlogDetails(@PathVariable Long id, Model model) {
        Optional<Blog> blogOptional = blogService.fetchById(id);
        if (blogOptional.isPresent()) {
            model.addAttribute("blogs", blogOptional.get());
            return "blogs/readmore.html";
        } else {
            // Handle case when blog is not found
            model.addAttribute("errorMessage", "Blog not found");
            return "blogs/blogs_page.html";
        }
    }

    @GetMapping("/user-blogs")
    public String getUserBlogs(Model model, Authentication authentication) {
        // Get the email of the logged-in user from the Authentication object
        String userEmail = authentication.getName();

        List<Blog> userBlogs = blogService.getBlogsByUserEmail(userEmail);

        model.addAttribute("blogs", userBlogs);
        return "blogs/yourblogs.html";
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
































//Made by aashista karki