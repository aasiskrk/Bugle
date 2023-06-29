package com.system.bugle.controller;


import com.system.bugle.dto.DepartmentDto;
import com.system.bugle.entity.user_management.Department;
import com.system.bugle.services.user_management.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> getData() {
        return departmentService.getData();
    }

    @GetMapping("getById/{id}")
    public Optional<Department> getById(@PathVariable Integer id) {
        return departmentService.getById(id);
    }

    @DeleteMapping("deleteById/{id}")
    public String deleteById(@PathVariable Integer id) {
        departmentService.deleteById(id);
        return "deleted successfully";
    }


    @PostMapping("save")
    public String saveData(@Valid DepartmentDto departmentDto,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);

            return null;
        }
        departmentService.saveData(departmentDto);
        return "data saved";
    }


    @GetMapping("getAll")
    public List<Department> getAllData() {
        return departmentService.getAllData();
    }

    @GetMapping("fetchById/{id}")
    public Optional<Department> fetchById(@PathVariable Integer id){
        return departmentService.fetchById(id);
    }

    @DeleteMapping("dropById/{id}")
    public String dropById(@PathVariable Integer id){
        departmentService.dropById(id);
        return "deleted successfully";
    }

    @GetMapping("/sendEmail")
    public String sendRegistrationEmail() {
        this.departmentService.sendEmail();
        return "emailsuccess";
    }

}
