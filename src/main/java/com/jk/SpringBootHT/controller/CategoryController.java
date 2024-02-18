package com.jk.SpringBootHT.controller;

import com.jk.SpringBootHT.entity.Category;
import com.jk.SpringBootHT.entity.EventCategory;
import com.jk.SpringBootHT.service.CategoryService;
import com.jk.SpringBootHT.service.EventCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private EventCategoryService eventCategoryService;

    @GetMapping("/showAddCategoryForm")
    public String showAddCategoryForm(Model model){
        List<Category> allCategories = categoryService.getAllCategories();
        model.addAttribute("allCategories", allCategories);
        return "new_category";
    }
    @GetMapping("/listCategories")
    public String listCategories(Model model){
        List<Category> allCategories = categoryService.getAllCategories();
        model.addAttribute("allCategories", allCategories);
        return "list_categories";
    }

    @PostMapping("saveCategory")
    public String saveCategory(@RequestParam("categoryTitle") String newCategoryTitle, RedirectAttributes redirectAttributes) {
        if (!newCategoryTitle.startsWith("#") && !newCategoryTitle.equals("")) {
            newCategoryTitle = "#" + newCategoryTitle;
        }
        // Tarkastetaan, löytyykö kyseinen kategoria ennestään
        Category existingCategory = categoryService.getCategoryByName(newCategoryTitle);
        if (existingCategory != null) {
            // Jos löytyy, lähetetään virhe ilmoitus redirect -sivulle
            redirectAttributes.addFlashAttribute("errorMessage", "Category '" + newCategoryTitle + "' already exists");
        } else {
            Category category = new Category();
            category.setCategoryName(newCategoryTitle);

            categoryService.saveCategory(category);
        }

        // Päivitetään sivu uudelleen, näyttäen muutokset
        return "redirect:/showAddCategoryForm";

    }

    @PostMapping("/updateCategory")
    public String updateCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);

        return "redirect:/showAddCategoryForm";
    }

    @GetMapping("/showCategoryEditForm/{id}")
    public String showCategoryEditForm(@PathVariable(value = "id") long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);

        return "edit_category";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable long id, RedirectAttributes redirectAttributes) {
        // Tarkastetaan, onko kategoria yhdistettynä johonkin eventtiin
        EventCategory existingEvent = eventCategoryService.getEventCategoryByCategoryId(id);
        if (existingEvent != null) {
            // Jos on, lähetetään virhe ilmoitus redirect -sivulle
            redirectAttributes.addFlashAttribute("errorMessage", "Category cannot be deleted, since it has an event bound to it");
        } else {
            categoryService.deleteCategoryById(id);
        }
        return "redirect:/showAddCategoryForm";
    }
}
