package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Category;
import hu.okrim.productratingapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category getCategoryById(Integer id) {
        return null;
    }
    @Override
    public Category addCategory(Category brand) {
        return categoryRepository.save(brand);
    }
    @Override
    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        for (Category brand : categoryRepository.findAll()) {
            categoryList.add(brand);
        }
        return categoryList;
    }
    @Override
    public void deleteCategory(Category brand) {
        categoryRepository.delete(brand);
    }
}
