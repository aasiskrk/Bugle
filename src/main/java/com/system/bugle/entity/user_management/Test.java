package com.system.bugle.entity.user_management;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Test {
    @Id
    private Integer id;
    private String name;
    private String age;
}
