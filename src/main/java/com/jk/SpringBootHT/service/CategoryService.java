package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void saveCategory(Category category);
    Category getCategoryById(long id);
    Category getCategoryByName(String name);
    void deleteCategoryById(long id);
}
