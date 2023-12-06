package com.jk.SpringBootHT.model;

import jakarta.persistence.*;

@Entity
@Table(name = "event_categories")
public class EventCategory {
    @Id
    @Column(name = "event_id")
    private Long eventId;

    @Id
    @Column(name = "category_id")
    private Long categoryId;

    public EventCategory(Long eventId, Long categoryId) {
        this.eventId = eventId;
        this.categoryId = categoryId;
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
