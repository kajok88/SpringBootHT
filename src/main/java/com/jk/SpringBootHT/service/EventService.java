package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();
    void saveEvent(Event event);
    Event getEventById(long id);
    void deleteEventById(long id);


}
