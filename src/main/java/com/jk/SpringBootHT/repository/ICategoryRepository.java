package com.jk.SpringBootHT.repository;

import com.jk.SpringBootHT.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(String categoryName);
    List<Category> findByUserId(Long userId);
}
