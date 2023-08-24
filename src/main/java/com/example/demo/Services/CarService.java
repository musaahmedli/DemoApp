package com.example.demo.Services;

import com.example.demo.Entities.AnnouncementStatus;
import com.example.demo.Entities.Car;
import com.example.demo.Repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepo repo;

    public List<Car> GetAllCar(){
        return repo.findAll();
    }

    public void CreateCar(Car car){
        repo.save(car);
    }

    public void DeleteCarById(long id){
        repo.deleteById(id);
    }

    public void UpdateCar(Car car){
        repo.save(car);
    }


}
