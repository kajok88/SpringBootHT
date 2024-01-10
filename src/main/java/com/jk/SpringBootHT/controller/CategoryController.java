package com.jk.SpringBootHT.controller;

import com.jk.SpringBootHT.entity.Category;
import com.jk.SpringBootHT.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/showAddCategoryForm")
    public String showAddCategoryForm(Model model){
        List<Category> allCategories = categoryService.getAllCategories();
        model.addAttribute("allCategories", allCategories);
        return "new_category";
    }
    @PostMapping("addCategory")
    public String addCategory(@RequestParam("categoryTitle") String categoryTitle, Model model) {
        Category category = new Category();
        category.setCategoryName(categoryTitle);

        categoryService.saveCategory(category);
        // Update the model with the updated list of categories
//        List<Category> allCategories = categoryService.getAllCategories();
//        model.addAttribute("allCategories", allCategories);

        return "redirect:/showAddCategoryForm"; // Redirect to the same page
    }
}
