package com.system.bugle.dto;

import com.system.bugle.entity.user_management.Blog;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.PathVariable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {

    private String uemail;

    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author name is required")
    private String author;

    @NotBlank(message = "Content is required")
    private String content;


    private LocalDateTime dateTime;

    public BlogDto(Blog blog) {
        this.uemail=blog.getUemail();
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.author = blog.getAuthor();
        this.content = blog.getContent();
        this.dateTime = blog.getDateTime();
    }
}
























//Made by aashista karki
