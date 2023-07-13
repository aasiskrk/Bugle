package com.system.bugle.dto;

import com.system.bugle.entity.user_management.Blog;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {

    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author name is required")
    private String author;

    @NotBlank(message = "Content is required")
    private String content;

    public BlogDto(Blog blog) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.author = blog.getAuthor();
        this.content = blog.getContent();
    }
}
