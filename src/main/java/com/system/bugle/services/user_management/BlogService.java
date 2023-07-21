package com.system.bugle.services.user_management;

import com.system.bugle.dto.BlogDto;
import com.system.bugle.entity.user_management.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    void deleteById(Long id);
    void saveBlog(BlogDto blogDto, String uemail);

    List<Blog> getAllBlogs();

    List<Blog> getBlogsByUserEmail(String userEmail);

    Optional<Blog> fetchById(Long id);
}
