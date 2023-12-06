package com.jk.SpringBootHT.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "categories")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "category_name")
    private String categoryName;

    public Category(Long categoryId, Long userId, String categoryName) {
        this.categoryId = categoryId;
        this.userId = userId;
        this.categoryName = categoryName;
    }

    public Category() {

    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
