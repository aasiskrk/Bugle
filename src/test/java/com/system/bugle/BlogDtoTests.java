package com.system.bugle;

import com.system.bugle.dto.BlogDto;
import com.system.bugle.entity.user_management.Blog;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BlogDtoTests {

    @Test
    public void constructorWithBlogTest() {
        Blog blog = new Blog();
        blog.setId(1L);
        blog.setTitle("Sample Blog");
        blog.setAuthor("John Doe");
        blog.setContent("This is a sample blog content");

        BlogDto blogDto = new BlogDto(blog);

        assertThat(blogDto.getId()).isEqualTo(1L);
        assertThat(blogDto.getTitle()).isEqualTo("Sample Blog");
        assertThat(blogDto.getAuthor()).isEqualTo("John Doe");
        assertThat(blogDto.getContent()).isEqualTo("This is a sample blog content");
    }
}
