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
}
