package com.jk.SpringBootHT.controller;

import com.jk.SpringBootHT.entity.Event;
import com.jk.SpringBootHT.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/events")
public class TestiEventController {

    private final IEventRepository eventRepository;

    @Autowired
    public TestiEventController(IEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Read All Events
    @GetMapping("/list")
    public String listEvents(Model model) {
        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        model.addAttribute("event", new Event()); // for the create form
        return "index";
    }

    // Process form for creating a new event
    @PostMapping("/create")
    public String createEvent(@ModelAttribute Event event) {
        eventRepository.save(event);
        return "redirect:/events/list";
    }

    // Display form for updating an existing event
    @GetMapping("/edit/{eventId}")
    public String showUpdateForm(@PathVariable Long eventId, Model model) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            model.addAttribute("event", optionalEvent.get());
        } else {
            // Handle not found scenario
        }
        return "index";
    }

    // Process form for updating an existing event
    @PostMapping("/edit/{eventId}")
    public String updateEvent(@PathVariable Long eventId, @ModelAttribute Event updatedEvent) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            // Update the fields of the existing event
            event.setEventTitle(updatedEvent.getEventTitle());
            event.setEventDescription(updatedEvent.getEventDescription());
            event.setEventDate(updatedEvent.getEventDate());
            // Update other fields as needed

            eventRepository.save(event);
        } else {
            // Handle not found scenario
        }
        return "redirect:/events/list";
    }

    // Delete an event
    @GetMapping("/delete/{eventId}")
    public String deleteEvent(@PathVariable Long eventId) {
        eventRepository.deleteById(eventId);
        return "redirect:/events/list";
    }
}
