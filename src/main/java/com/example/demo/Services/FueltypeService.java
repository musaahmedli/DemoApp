package com.example.demo.Services;

import com.example.demo.Entities.FuelType;
import com.example.demo.Entities.UserType;
import com.example.demo.Repos.FuelTypeRepo;
import com.example.demo.Repos.UserTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FueltypeService {
    @Autowired
    private FuelTypeRepo repo;
    public List<FuelType> GetAllFueltypes(){
        return repo.findAll();
    }

    public void CreateFueltype(FuelType fuelType){
        repo.save(fuelType);
    }

    public void DeleteFueltypeById(long id){
        repo.deleteById(id);
    }

    public void UpdateFueltype(FuelType fuelType){
        repo.save(fuelType);
    }
}
