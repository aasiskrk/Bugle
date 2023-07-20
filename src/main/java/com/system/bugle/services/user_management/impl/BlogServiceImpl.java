package com.system.bugle.services.user_management.impl;
//Made by aashista karki
import com.system.bugle.dto.BlogDto;
import com.system.bugle.entity.user_management.Blog;
import com.system.bugle.repo.user_management.BlogRepo;
import com.system.bugle.services.user_management.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        blog.setUemail(uemail);
        blogRepo.save(blog);
    }
    @Override
    public Optional<Blog> fetchById(Long id) {
        return blogRepo.findById(id);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    //Made by aashista karki
}
