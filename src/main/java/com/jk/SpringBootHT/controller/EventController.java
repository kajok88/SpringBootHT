package com.jk.SpringBootHT.controller;

import com.jk.SpringBootHT.entity.Event;
import com.jk.SpringBootHT.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;
    @GetMapping("/")
    public String showEvents(Model model) {
        model.addAttribute("listEvents", eventService.getAllEvents());
        return "index";
    }

    @GetMapping("/showAddEventForm")
    public String showAddEventForm(Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        return "new_event";
    }

    @PostMapping("/saveEvent")
    public String saveEvent(@ModelAttribute("event") Event event) {
        eventService.saveEvent(event);
        return "redirect:/";
    }
    @GetMapping("/showEventEditForm/{id}")
    public String showEventEditForm(@PathVariable(value = "id") long id, Model model) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        return "edit_event";
    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.eventService.deleteEventById(id);
        return "redirect:/";
    }
}
