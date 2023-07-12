package com.system.bugle.controller;


import com.system.bugle.entity.user_management.User;
import com.system.bugle.pojo.user_management.UserPojo;
import com.system.bugle.services.user_management.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/file_server";

    @GetMapping
    public String getPage() {
        return "hello_page";
    }


    @GetMapping("/create")
    public String getCreatePage() {
        return "user/create";
    }


    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new UserPojo());
        return "register";
    }

    @PostMapping("/create")
    public String createUser(@Valid UserPojo userPojo,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/user/register";
        }

        userService.save(userPojo);
        redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");


        return "redirect:/user/list";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.fetchById(id);
        model.addAttribute("user", new UserPojo(user));
        return "register";
    }

    @GetMapping("/list")
    public String getUSerList(Model model) {
        List<User> users = userService.fetchAll();


        model.addAttribute("userList", users.stream().map(user ->
                User.builder()
                        .id(user.getId())
                        .imageBase64(getImageBase64(user.getImage()))
                        .email(user.getEmail())
                        .fullName(user.getFullName())
                        .build()

        ));

//        model.addAttribute("UPLOAD_DIRECTORY", "/" + UPLOAD_DIRECTORY);

        return "user_list";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        userService.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Row delete successfully");
        return "redirect:/user/list";
    }

    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;

    }
    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/file_server/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }


}
