package com.system.bugle.services.user_management.impl;

import com.system.bugle.dto.BlogDto;
import com.system.bugle.entity.user_management.Blog;
import com.system.bugle.repo.user_management.BlogRepo;
import com.system.bugle.services.user_management.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepo blogRepo;

    public BlogServiceImpl(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    @Override
    public void saveBlog(BlogDto blogDto) {
        Blog blog = new Blog();
        blog.setTitle(blogDto.getTitle());
        blog.setAuthor(blogDto.getAuthor());
        blog.setContent(blogDto.getContent());
        blogRepo.save(blog);


    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }
}
