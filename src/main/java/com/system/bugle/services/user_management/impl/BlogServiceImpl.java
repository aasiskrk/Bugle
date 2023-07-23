package com.system.bugle.services.user_management.impl;
//Made by aashista karki
import com.system.bugle.dto.BlogDto;
import com.system.bugle.entity.user_management.Blog;
import com.system.bugle.repo.user_management.BlogRepo;
import com.system.bugle.services.user_management.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepo blogRepo;

    public BlogServiceImpl(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    @Override
    @Transactional
    public void saveBlog(BlogDto blogDto, String uemail) {
        Blog blog = new Blog();
        blog.setTitle(blogDto.getTitle());
        blog.setAuthor(blogDto.getAuthor());
        blog.setContent(blogDto.getContent());
        blog.setDateTime(LocalDateTime.now());
        blog.setUemail(uemail);
        blogRepo.save(blog);
    }

    @Override
    public List<Blog> getBlogsByUserEmail(String userEmail) {
        return blogRepo.findByUemail(userEmail);
    }
    @Override
    public Optional<Blog> fetchById(Long id) {
        return blogRepo.findById(id);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    public void deleteById(Long id){
        blogRepo.deleteById(id);
    }


    @Override
    @Transactional
    public void updateBlog(Long id, BlogDto blogDto) {
        Optional<Blog> blogOptional = blogRepo.findById(id);
        if (blogOptional.isPresent()) {
            Blog existingBlog = blogOptional.get();
            existingBlog.setTitle(blogDto.getTitle());
            existingBlog.setAuthor(blogDto.getAuthor());
            existingBlog.setContent(blogDto.getContent());
            // Update any other fields as needed
            blogRepo.save(existingBlog);
        }
    }

    //Made by aashista karki
}
