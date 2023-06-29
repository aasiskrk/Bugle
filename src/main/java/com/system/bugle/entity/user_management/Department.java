package com.system.bugle.entity.user_management;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class Department {
    @Id
    @SequenceGenerator(name = "department_id_seq_gen", sequenceName = "department_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "department_id_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="department_name",length = 50,nullable = false)
    private String departmentName;

}
