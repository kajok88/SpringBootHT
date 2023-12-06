package com.jk.SpringBootHT.controller;

import com.jk.SpringBootHT.entity.Event;
import com.jk.SpringBootHT.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestiEventController {
    @Autowired
    IEventRepository iEventRepository;
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents(@RequestParam(required = false) String eventTitle){
        try {
            List<Event> events = new ArrayList<Event>();
            return new ResponseEntity<>(events, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
