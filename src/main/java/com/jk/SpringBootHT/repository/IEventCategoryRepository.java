package com.jk.SpringBootHT.repository;

import com.jk.SpringBootHT.entity.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventCategoryRepository extends JpaRepository<EventCategory, Long> {
    EventCategory findByCategoryId(long id);
    EventCategory findByEventId(long id);
}
