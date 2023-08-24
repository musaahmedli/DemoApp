package com.example.demo.Services;

import com.example.demo.Entities.City;
import com.example.demo.Entities.Gearbox;
import com.example.demo.Repos.CityRepo;
import com.example.demo.Repos.GearboxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepo repo;
    public List<City> GetAllCities(){
        return repo.findAll();
    }

    public void CreateCity(City city){
        repo.save(city);
    }

    public void DeleteCityById(long id){
        repo.deleteById(id);
    }

    public void UpdateCity(City city){
        repo.save(city);
    }
}
