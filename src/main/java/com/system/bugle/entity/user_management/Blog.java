package com.system.bugle.entity.user_management;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String title;

    private String author;

    private String content;

    // Constructors, getters, and setters

    public Blog() {
    }

    public Blog(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public BigInteger getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
