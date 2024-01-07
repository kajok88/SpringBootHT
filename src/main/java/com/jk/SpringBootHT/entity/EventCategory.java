//package com.jk.SpringBootHT.entity;
//
//import com.jk.SpringBootHT.model.EventCategoryId;
//import jakarta.persistence.*;
//
//import java.io.Serializable;
//
//@Entity
//@Table(name = "event_categories")
//@IdClass(EventCategoryId.class)
//public class EventCategory implements Serializable {
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "event_id")
//    private Long eventId;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "event_id")
//    private Long categoryId;
//
//    public EventCategory(Long eventId, Long categoryId) {
//        this.eventId = eventId;
//        this.categoryId = categoryId;
//    }
//
//    public EventCategory() {
//
//    }
//
//    public Long getEventId() {
//        return eventId;
//    }
//
//    public void setEventId(Long eventId) {
//        this.eventId = eventId;
//    }
//
//    public Long getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Long categoryId) {
//        this.categoryId = categoryId;
//    }
//}
