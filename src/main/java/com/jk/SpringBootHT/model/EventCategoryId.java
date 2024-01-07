//package com.jk.SpringBootHT.model;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//// This class is for EventCategory's composite keys
//public class EventCategoryId implements Serializable {
//    private Long eventId;
//    private Long categoryId;
//
//    public EventCategoryId(Long eventId, Long categoryId) {
//        this.eventId = eventId;
//        this.categoryId = categoryId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof EventCategoryId that)) return false;
//        return Objects.equals(eventId, that.eventId) && Objects.equals(categoryId, that.categoryId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(eventId, categoryId);
//    }
//}
