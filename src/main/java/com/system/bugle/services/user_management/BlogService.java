package com.system.bugle.services.user_management;

import com.system.bugle.dto.BlogDto;
import com.system.bugle.entity.user_management.Blog;

import java.util.List;

public interface BlogService {

    static void saveBlog(BlogDto blogDto);

    List<Blog> getAllBlogs();
}
