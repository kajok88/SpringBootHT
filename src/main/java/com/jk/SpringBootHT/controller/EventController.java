package com.jk.SpringBootHT.controller;

import com.jk.SpringBootHT.entity.Category;
import com.jk.SpringBootHT.entity.Event;
import com.jk.SpringBootHT.entity.EventCategory;
import com.jk.SpringBootHT.service.CategoryService;
import com.jk.SpringBootHT.service.EventCategoryService;
import com.jk.SpringBootHT.service.EventService;
import com.jk.SpringBootHT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private EventCategoryService eventCategoryService;


    @GetMapping("/")
    public String showEvents(Model model) {
        model.addAttribute("listEvents", eventService.getAllEvents());
        return "index";
    }
    @GetMapping("/listEvents")
    public String listEvents(Model model) {
        model.addAttribute("listEvents", eventService.getAllEvents());
        return "list_events";
    }

    @GetMapping("/showEvent/{id}")
    public String showEventById(@PathVariable Long id, Model model) {
        try {
            Event event = eventService.getEventById(id);
            model.addAttribute("event", event);
            return "event_by_id";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "list_events";  // Assuming you have a Thymeleaf template named "error"
        }
    }

    @GetMapping("listEventsByCategory/{id}")
    public String listEventsByCategory(@PathVariable(value = "id") long id, Model model)  {
        try {
            Category category = categoryService.getCategoryById(id);
            List<EventCategory> eventCategoriesByCategory = (eventCategoryService.getEventCategoriesByCategoryId(id));
            List<Event> events = new ArrayList<>();

            for (EventCategory eventId : eventCategoriesByCategory) {
                Event fetchedEvent = eventService.getEventById(eventId.getEventId());
                events.add(fetchedEvent);
            }

            model.addAttribute("listEvents", events);
            model.addAttribute("category", category);
            return "category_by_name";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "list_categories";
        }

    }

    @GetMapping("/showAddEventForm")
    public String showAddEventForm(Model model) {
        Event event = new Event();
        List<Category> allCategories = categoryService.getAllCategories();

        model.addAttribute("event", event);
        model.addAttribute("allCategories", allCategories);

        return "new_event";
    }

    // Käytetään tallentamiseen tai päivittämiseen.
    @PostMapping("/saveOrUpdateEvent")
    public String saveEvent(@ModelAttribute("event") Event event,
                            @RequestParam("categoryName") String categoryName) {

        Category category = categoryService.getCategoryByName(categoryName);

        // Alustetaan kategoria -lista eventille ja lisätään siihen kategoria
        List<Category> categories = event.getCategories();
        if (categories == null) {
            categories = new ArrayList<>();
            event.setCategories(categories);
        }
        categories.add(category);

        eventService.saveEvent(event);
        return "redirect:/listEvents";
    }


    @GetMapping("/showEventEditForm/{id}")
    public String showEventEditForm(@PathVariable(value = "id") long id, Model model) {
        Event event = eventService.getEventById(id);
        List<Category> allCategories = categoryService.getAllCategories();

        model.addAttribute("event", event);
        model.addAttribute("allCategories", allCategories);

        return "edit_event";
    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.eventService.deleteEventById(id);
        return "redirect:/listEvents";
    }
}
