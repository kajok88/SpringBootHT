package com.jk.SpringBootHT.repository;

import com.jk.SpringBootHT.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventRepository extends JpaRepository<Event, Long> {
}
