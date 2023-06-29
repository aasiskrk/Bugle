package com.system.bugle.controller;

import com.system.bugle.dto.TestDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("getAll")
    public String getAllData(){

        return "fetchedData";
    }


    @PostMapping("create")
    public String createMethod(@Valid TestDto testDto){

        System.out.println(testDto.getAge());
        System.out.println(testDto.getName());

        return "created successfully";
    }

}
