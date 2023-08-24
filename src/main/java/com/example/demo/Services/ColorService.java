package com.example.demo.Services;

import com.example.demo.Entities.Color;
import com.example.demo.Entities.Gearbox;
import com.example.demo.Repos.ColorRepo;
import com.example.demo.Repos.GearboxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    @Autowired
    private ColorRepo repo;
    public List<Color> GetAllColors(){
        return repo.findAll();
    }

    public void CreateColor(Color color){
        repo.save(color);
    }

    public void DeleteColorById(long id){
        repo.deleteById(id);
    }

    public void UpdateColor(Color color){
        repo.save(color);
    }
}
