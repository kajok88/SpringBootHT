package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.Category;
import com.jk.SpringBootHT.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category){
        this.categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(long id){
        Optional<Category> optional = categoryRepository.findById(id);
        Category category = null;
        if (optional.isPresent()){
            category = optional.get();
        } else {
            throw new RuntimeException(" Category not found by id :: " + id);
        }
        return category;
    }

    @Override
    public Category getCategoryByName(String name){
        return categoryRepository.findByCategoryName(name);
    }


    // Jos halutaan tehdä tyhjästä kategoria syötteestä #undefied
    @Override
    public Category getOrCreateCategoryByName(String name) {
        Category category = getCategoryByName(name);
        if (category == null) {
            category = new Category();
            category.setCategoryName("#undefined");
            saveCategory(category);
        }
        return category;
    }

    @Override
    public void deleteCategoryById(long id){
        this.categoryRepository.deleteById(id);
    }
}
