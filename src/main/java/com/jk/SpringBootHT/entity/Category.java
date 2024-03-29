package com.jk.SpringBootHT.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

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

    @ManyToMany(mappedBy = "categories")
    private List<Event> events;

    public Category(Long categoryId, Long userId, String categoryName, List<Event> events) {
        this.categoryId = categoryId;
        this.userId = userId;
        this.categoryName = categoryName;
        this.events = events;
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

        // Lisätään '#' jokaisen kategoria -nimen eteen
        if (!categoryName.startsWith("#") && !categoryName.equals("")) {
            this.categoryName = "#" + categoryName;
        } else {
            this.categoryName = categoryName;
        }
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
