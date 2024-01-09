package com.jk.SpringBootHT.controller;

import com.jk.SpringBootHT.entity.Category;
import com.jk.SpringBootHT.entity.Event;
import com.jk.SpringBootHT.service.CategoryService;
import com.jk.SpringBootHT.service.EventService;
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
    public String saveEvent(@ModelAttribute("event") Event event,
                            @RequestParam("categoryName") String categoryName) {
        // Check if the category already exists
        Category category = categoryService.getCategoryByName(categoryName);
        if (category == null) {
            // If not, create a new category
            category = new Category();
            category.setCategoryName(categoryName);
            categoryService.saveCategory(category);
        }
        // Add the category to the event
        List<Category> categories = event.getCategories();
        if (categories == null) {
            categories = new ArrayList<>();
            event.setCategories(categories);
        }
        categories.add(category);

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
