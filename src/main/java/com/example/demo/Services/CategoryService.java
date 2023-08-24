package com.example.demo.Services;

import com.example.demo.Entities.Category;
import com.example.demo.Entities.Gearbox;
import com.example.demo.Repos.CategoryRepo;
import com.example.demo.Repos.GearboxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo repo;
    public List<Category> GetAllCategories(){
        return repo.findAll();
    }

    public void CreateCategory(Category category){
        repo.save(category);
    }

    public void DeleteCategoryById(long id){
        repo.deleteById(id);
    }

    public void UpdateCategory(Category category){
        repo.save(category);
    }

}
