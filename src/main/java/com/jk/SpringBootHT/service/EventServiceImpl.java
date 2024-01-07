package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.Event;
import com.jk.SpringBootHT.repository.IEventRepository;


import java.util.List;

public class EventServiceImpl implements EventService{

    private IEventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
