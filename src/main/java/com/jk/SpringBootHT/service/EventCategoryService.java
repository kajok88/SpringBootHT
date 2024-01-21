package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.EventCategory;

import java.util.List;

public interface EventCategoryService {
    EventCategory getEventCategoryByEventId(long id);
    EventCategory getEventCategoryByCategoryId(long id);
    List<EventCategory> getEventCategoriesByCategoryId(long id);
}
