package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.EventCategory;

public interface EventCategoryService {
    EventCategory getCategoryByEventId(long id);
    EventCategory getEventByCategoryId(long id);
}
