package hu.okrim.productratingapp.web;

import hu.okrim.productratingapp.entity.Category;
import hu.okrim.productratingapp.entity.Constants;
import hu.okrim.productratingapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("")
    public String listPeople(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }
    @PostMapping("/add-category")
    public String addCategory(@RequestParam("name") String name, @RequestParam("description") String description, RedirectAttributes redirectAttributes) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryService.addCategory(category);
        String status = Constants.SUCCESS_STATUS;
        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/categories";
    }
    @PostMapping("/delete-category")
    public String deleteCategory(@RequestParam("category") Category person, RedirectAttributes redirectAttributes){
        categoryService.deleteCategory(person);
        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        return "redirect:/categories";
    }
}
