package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.Event;
import com.jk.SpringBootHT.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private IEventRepository eventRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    public void saveEvent(Event event) {

        // Noudetaan nykyisen käyttäjän authentikaatio objekti, ja siitä käyttäjänimi
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        // Asetetaan uudelle eventille käyttäjän ID.
        Long userId = userService.getUserIdByUsername(currentUsername);
        event.setUserId(userId);

        eventRepository.save(event);
    }

    @Override
    public Event getEventById(long id) {
        Optional< Event > optional = eventRepository.findById(id);
        Event event = null;
        if (optional.isPresent()) {
            event = optional.get();
        } else {
            throw new RuntimeException(" Note not found by id: " + id);
        }
        return event;
    }

    @Override
    public void deleteEventById(long id) {
        this.eventRepository.deleteById(id);
    }
}
