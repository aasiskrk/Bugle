package com.system.bugle.dto;

import com.system.bugle.entity.user_management.Department;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Integer id;

    @NotNull(message = "this is required field")
    @NotEmpty(message = "this is required field")
    private String departmentName;

    public DepartmentDto(Department department){
        this.id=department.getId();
        this.departmentName=department.getDepartmentName();
    }
}
