package com.example.demo.Services;

import com.example.demo.Entities.Car;
import com.example.demo.Entities.CarStatus;
import com.example.demo.Repos.CarStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarStatusService {
    @Autowired
    private CarStatusRepo repo;
    public List<CarStatus> GetAllCarStatus(){
        return repo.findAll();
    }

    public void CreateCarStatus(CarStatus carStatus){
        repo.save(carStatus);
    }

    public void DeleteCarStatusById(long id){
        repo.deleteById(id);
    }

    public void UpdateCarStatus(CarStatus carStatus){
        repo.save(carStatus);
    }

}
