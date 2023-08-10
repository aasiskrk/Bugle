package com.system.bugle.services.user_management.impl;

import com.system.bugle.dto.TagsDto;
import com.system.bugle.entity.user_management.Tags;
import com.system.bugle.repo.user_management.TagsRepo;
import com.system.bugle.services.user_management.TagsService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagsServiceImpl implements TagsService {

    private final TagsRepo tagsRepo;

    public TagsServiceImpl(TagsRepo tagsRepo) {
        this.tagsRepo = tagsRepo;
    }

    @Override
    @Transactional
    public void saveTags(TagsDto tagsDto) {
        Tags tags= new Tags();
        tags.setTags(tagsDto.getTags());
        tags.setTagid(tagsDto.getTagid());
        tagsRepo.save(tags);
    }

    @Override
    public List<Tags> getAllTags() {
        return tagsRepo.findAll();
    }
}
