package com.system.bugle.dto;

import com.system.bugle.entity.user_management.Blog;
import com.system.bugle.entity.user_management.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {

    private BigInteger id;

    @NotNull(message = "Title is required")
    private String title;
    @NotNull(message = "Author name is required")
    private String author;
    @NotNull(message = "Content is required")
    private String content;

    public BlogDto(Blog blog){
        this.id=blog.getId();
        this.title=blog.getTitle();
        this.author=blog.getAuthor();
        this.content=blog.getContent();
    }
}
