package com.example.demo.Services;

import com.example.demo.Entities.Marka;
import com.example.demo.Entities.UserType;
import com.example.demo.Repos.MarkaRepo;
import com.example.demo.Repos.UserTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkaService {
    @Autowired
    private MarkaRepo repo;
    public List<Marka> GetAllMarka(){
        return repo.findAll();
    }

    public void CreateMarka(Marka marka){
        repo.save(marka);
    }

    public void DeleteMarkaById(long id){
        repo.deleteById(id);
    }

    public void UpdateMarka(Marka marka){
        repo.save(marka);
    }
}
