package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.EventCategory;
import com.jk.SpringBootHT.repository.IEventCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventCategoryServiceImpl implements EventCategoryService{
    @Autowired
    private IEventCategoryRepository eventCategoryRepository;
    @Override
    public EventCategory getEventCategoryByEventId(long id){
        return eventCategoryRepository.findByEventId(id);
    }
    @Override
    public EventCategory getEventCategoryByCategoryId(long id){
        return eventCategoryRepository.findByCategoryId(id);
    }
    @Override
    public List<EventCategory> getEventCategoriesByCategoryId(long id) { return eventCategoryRepository.getByCategoryId(id); }
}
