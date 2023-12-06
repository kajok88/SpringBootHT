package com.jk.SpringBootHT.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "event_title")
    private String eventTitle;
    @Column(name = "event_description")
    private String eventDescription;
    @Column(name = "event_date")
    private LocalDate eventDate;
    @Column(name = "event_time")
    private LocalTime eventTime;
    @Column(name = "due_date")
    private LocalDate dueDate;
}
