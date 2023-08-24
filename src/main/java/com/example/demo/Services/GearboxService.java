package com.example.demo.Services;

import com.example.demo.Entities.Gearbox;
import com.example.demo.Entities.UserType;
import com.example.demo.Repos.GearboxRepo;
import com.example.demo.Repos.UserTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GearboxService {
    @Autowired
    private GearboxRepo repo;
    public List<Gearbox> GetAllGearbox(){
        return repo.findAll();
    }

    public void CreateGearbox(Gearbox gearbox){
        repo.save(gearbox);
    }

    public void DeleteGearboxById(long id){
        repo.deleteById(id);
    }

    public void UpdateGearbox(Gearbox gearbox){
        repo.save(gearbox);
    }
}
