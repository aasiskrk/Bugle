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
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/th-blogs")
public class ThymeLeafBlogController {

    private final BlogService blogService;



    public ThymeLeafBlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/goProfile")
    public  String displayprofile(){return "user_list.html";}
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
        blogDto.setDateTime(LocalDateTime.now());

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
        Collections.sort(userBlogs, Comparator.comparing(Blog::getDateTime).reversed());

        model.addAttribute("blogs", userBlogs);
        return "blogs/yourblogs.html";
    }

    @GetMapping("/getAll")
    public String getAllBlogs(Model model) {
        List<Blog> blogs = blogService.getAllBlogs();

        Collections.sort(blogs, Comparator.comparing(Blog::getDateTime).reversed());
        model.addAttribute("blogs", blogs);
        return "blogs/blogs_page.html";
    }


    @GetMapping("/deleteblog/{id}")
    public String deleteBlog(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        blogService.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Blog deleted successfully");
        return "redirect:/th-blogs/user-blogs";
    }


    @GetMapping("/editblog/{id}")
    public String showEditBlogForm(@PathVariable Long id, Model model) {
        Optional<Blog> blogOptional = blogService.fetchById(id);
        if (blogOptional.isPresent()) {
            BlogDto blogDto = new BlogDto(blogOptional.get());
            model.addAttribute("blogDto", blogDto);
            return "blogs/editblog.html";
        } else {
            // Handle case when blog is not found
            model.addAttribute("errorMessage", "Blog not found");
            return "blogs/blogs_page.html";
        }
    }

    @PostMapping("/update/{id}")
    public String updateBlog(@PathVariable Long id, @Valid BlogDto blogDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return "blogs/editblog.html";
        }
        blogService.updateBlog(id, blogDto);
        return "redirect:/th-blogs/user-blogs";
    }

    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/file_server/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }


}
































//Made by aashista karki