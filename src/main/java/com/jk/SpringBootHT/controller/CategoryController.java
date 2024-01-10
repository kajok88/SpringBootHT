package com.jk.SpringBootHT.controller;

import com.jk.SpringBootHT.entity.Category;
import com.jk.SpringBootHT.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String addCategory(@RequestParam("categoryTitle") String newCategoryTitle, RedirectAttributes redirectAttributes) {
        // Tarkastetaan, löytyykö kyseinen kategoria ennestään
        Category existingCategory = categoryService.getCategoryByName(newCategoryTitle);
        if (existingCategory != null) {
            // Jos löytyy, lähetetään virhe ilmoitus redirect -sivulle
            redirectAttributes.addFlashAttribute("errorMessage", "Category already exists");
        } else {
            Category category = new Category();
            category.setCategoryName(newCategoryTitle);

            categoryService.saveCategory(category);
        }

        // Päivitetään sivu uudelleen, näyttäen muutokset
        return "redirect:/showAddCategoryForm";

    }
}
