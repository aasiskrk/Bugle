//package com.system.bugle.controller;
//import com.system.bugle.dto.TagsDto;
//import com.system.bugle.entity.user_management.Tags;
//import com.system.bugle.services.user_management.TagsService;
//import jakarta.validation.Valid;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//
//@Controller
//@RequestMapping("/th-tags")
//public class ThymeLeafTagController {
//
//    private final TagsService tagsService;
//
//    public ThymeLeafTagController(TagsService tagsService) {
//        this.tagsService = tagsService;
//    }
//
//    //this part also gets the data and puts it in database and
//    //also fetches the data to display in the same page
//    @GetMapping("/create")
//    public String getTagFormGetAll(Model model) {
//        model.addAttribute("tagsDto", new TagsDto());
//        List<Tags> tags = tagsService.getAllTags();
//        model.addAttribute("tags", tags);
//        return "tagpart/tags.html";
//    }
//
//    @PostMapping("save")
//    public String saveTags(@Valid TagsDto tagsDto, BindingResult bindingResult, Authentication authentication) {
//        if (bindingResult.hasErrors()) {
//            // Handle validation errors
//            return "tagpart/tags.html";
//        }
//
//        tagsService.saveTags(tagsDto);
//        return "redirect:/th-tags/create";
//    }
//
////    @GetMapping("/create")
////    public String getAllTags(Model model) {
////        List<Tags> tags = tagsService.getAllTags();
////
////        model.addAttribute("tags", tags);
////        return "tagpart/tags.html";
////    }
//
//
//}
