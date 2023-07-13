package com.system.bugle.pojo.user_management;

import com.system.bugle.entity.user_management.Blog;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BlogPojo {

    private Long id;

    @NotEmpty(message = "Title can't be empty")
    private String title;

    @NotEmpty(message = "author name can't be empty")
    private String author;

    @NotEmpty(message = "Content can't be empty")
    private String content;

    public BlogPojo(Blog blog){
        this.id=blog.getId();
        this.title=blog.getTitle();
        this.author=blog.getAuthor();
        this.content=blog.getContent();
    }
}
