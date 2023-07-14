package com.system.bugle.entity.user_management;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "blog") // Optional: Specify the table name explicitly
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String content;


}
