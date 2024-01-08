package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.Event;
import com.jk.SpringBootHT.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private IEventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    @Override
    public void saveEvent(Event event) {
        this.eventRepository.save(event);
    }

    @Override
    public Event getEventById(long id) {
        Optional< Event > optional = eventRepository.findById(id);
        Event event = null;
        if (optional.isPresent()) {
            event = optional.get();
        } else {
            throw new RuntimeException(" Event not found by id :: " + id);
        }
        return event;
    }

    @Override
    public void deleteEventById(long id) {
        this.eventRepository.deleteById(id);
    }
}
