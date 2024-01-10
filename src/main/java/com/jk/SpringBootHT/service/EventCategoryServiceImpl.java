package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.Category;
import com.jk.SpringBootHT.entity.EventCategory;
import com.jk.SpringBootHT.repository.IEventCategoryRepository;
import com.jk.SpringBootHT.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventCategoryServiceImpl implements EventCategoryService{
    @Autowired
    private IEventCategoryRepository eventCategoryRepository;
    @Override
    public EventCategory getCategoryByEventId(long id){
        return eventCategoryRepository.findByEventId(id);
    }
    @Override
    public EventCategory getEventByCategoryId(long id){
        return eventCategoryRepository.findByCategoryId(id);
    }
}
