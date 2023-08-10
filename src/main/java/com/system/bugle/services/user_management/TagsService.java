package com.system.bugle.services.user_management;

import com.system.bugle.dto.TagsDto;
import com.system.bugle.entity.user_management.Tags;

import java.util.List;

public interface TagsService {


    List<Tags> getAllTags();
    void saveTags(TagsDto tagsDto);
}
