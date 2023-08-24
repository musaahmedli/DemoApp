package com.example.demo.Services;

import com.example.demo.Entities.Model;
import com.example.demo.Entities.UserType;
import com.example.demo.Repos.ModelRepo;
import com.example.demo.Repos.UserTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
    @Autowired
    private ModelRepo repo;
    public List<Model> GetAllModel(){
        return repo.findAll();
    }

    public void CreateModel(Model model){
        repo.save(model);
    }

    public void DeleteModelById(long id){
        repo.deleteById(id);
    }

    public void UpdateModel(Model model){
        repo.save(model);
    }
}
