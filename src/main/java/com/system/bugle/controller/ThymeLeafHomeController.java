package com.system.bugle.controller;
//Made by aashista karki

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/th-homepage")
public class ThymeLeafHomeController {

    @GetMapping("/goHome")
    public String displayHomePage() {
        return "homepage/home_page";
    }

    @GetMapping("/tags")
    public String displayTagPage(){return "tagpart/tags";}



}
