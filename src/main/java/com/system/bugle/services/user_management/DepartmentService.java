package com.system.bugle.services.user_management;

import com.system.bugle.dto.DepartmentDto;
import com.system.bugle.entity.user_management.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    void saveData(DepartmentDto departmentDto);

    List<Department> getData();

    Optional<Department> getById(Integer id);

    Department getByIdNoOpt(Integer id);

    void deleteById(Integer id);


    List<Department>  getAllData();

    Optional<Department> fetchById(Integer id);

    void dropById(Integer id);

    void sendEmail();
}
