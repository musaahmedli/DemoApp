package com.example.demo.Services;

import com.example.demo.Entities.Car;
import com.example.demo.Entities.Wheeldrive;
import com.example.demo.Repos.WheeldriveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WheeldriveService {
    @Autowired
    private WheeldriveRepo repo;
    public List<Wheeldrive> GetAllWheeldrives(){
        return repo.findAll();
    }

    public void CreateWheeldrive(Wheeldrive wheeldrive){
        repo.save(wheeldrive);
    }

    public void DeleteWheeldriveById(long id){
        repo.deleteById(id);
    }

    public void UpdateWheeldrive(Wheeldrive wheeldrive){
        repo.save(wheeldrive);
    }
}
