package com.jk.SpringBootHT.repository;

import com.jk.SpringBootHT.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEventRepository extends JpaRepository<Event, Long> {
    List<Event> findByUserId(Long userId);
}
