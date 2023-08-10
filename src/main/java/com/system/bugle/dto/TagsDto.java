package com.system.bugle.dto;


import com.system.bugle.entity.user_management.Blog;
import com.system.bugle.entity.user_management.Tags;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TagsDto {


    private Long tagid;

    @NotBlank(message = "Tags is required")
    private String tags;

    public TagsDto(Tags tags){
        this.tags=tags.getTags();
        this.tagid=tags.getTagid();
    }
}
