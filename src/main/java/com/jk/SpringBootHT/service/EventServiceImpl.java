package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.Event;
import com.jk.SpringBootHT.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

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
}
