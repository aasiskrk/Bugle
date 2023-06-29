package com.system.bugle.controller;


import com.system.bugle.dto.DepartmentDto;
import com.system.bugle.entity.user_management.Department;
import com.system.bugle.services.user_management.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/th-department")
@RequiredArgsConstructor
public class ThymeLeafDepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("table")
    public String getDataView(Model model) {
        model.addAttribute("departments", departmentService.getData());
        return "department/table.html";
    }

    @GetMapping("create")
    public String getFormPage(Model model) {
        model.addAttribute("department", new DepartmentDto());
        return "department/create.html";
    }


    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        Department department = departmentService.getByIdNoOpt(id);
        model.addAttribute("department", new DepartmentDto(department));
        return "department/create.html";
    }


    @GetMapping("table1")
    public String getTablePage(Model model) {
        model.addAttribute("departmentList", departmentService.getAllData());
        return "department/table1.html";
    }


    @GetMapping("create1")
    public String getCreate1Page(Model model) {
        model.addAttribute("departmentDto", new DepartmentDto());
        return "department/create1.html";
    }

    @PostMapping("save")
    public String saveData(@Valid DepartmentDto departmentDto,Model model,BindingResult bindingResult) throws IOException {
//        System.out.println(bindingResult.hasErrors());
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("'allErrors'", bindingResult.getAllErrors());
//            System.out.println(bindingResult.getAllErrors());
//            return "department/create1.html";
//        }
        departmentService.saveData(departmentDto);
        return "redirect:/th-department/table1";
    }

    @GetMapping("edit1/{id}")
    public String getUpdateData(@PathVariable Integer id, Model model) {
        Department department = departmentService.getByIdNoOpt(id);
        model.addAttribute("departmentDto", new DepartmentDto(department));
        return "department/create1.html";
    }

    @GetMapping("delete1/{id}")
    public String getDeletedData(@PathVariable Integer id) {
        departmentService.deleteById(id);
        return "redirect:/th-department/table1";
    }


}
