package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.Category;
import com.jk.SpringBootHT.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<Category> getAllCategories(){

        // Noudetaan nykyisen käyttäjän authentikaatio objekti, ja siitä käyttäjänimi
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        // Palautetaan kaikki kirjautuneen käyttäjän kategoriat
        Long userId = userService.getUserIdByUsername(currentUsername);
        return categoryRepository.findByUserId(userId);
    }

    @Override
    public void saveCategory(Category category){

        // Noudetaan kirjautuneen käyttäjän authentikaatio objekti, ja siitä käyttäjänimi
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        // Asetetaan uudelle kategorialle käyttäjän ID.
        Long userId = userService.getUserIdByUsername(currentUsername);
        category.setUserId(userId);

        categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(long id){
        Optional<Category> optional = categoryRepository.findById(id);
        Category category = null;
        if (optional.isPresent()){
            category = optional.get();
        } else {
            throw new RuntimeException(" Category not found by id: " + id);
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
