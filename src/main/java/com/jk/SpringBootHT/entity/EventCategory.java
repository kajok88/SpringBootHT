package com.jk.SpringBootHT.entity;

import com.jk.SpringBootHT.model.EventCategoryId;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@IdClass(EventCategoryId.class)
@Table(name = "event_categories")
public class EventCategory implements Serializable {
    @Id
    @Column(name = "event_Id")
    private Long eventId;

    @Id
    @Column(name = "category_Id")
    private Long categoryId;

    public EventCategory(Long eventId, Long categoryId) {
        this.eventId = eventId;
        this.categoryId = categoryId;
    }
    public EventCategory() {

    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
