package com.example.demo.Services;

import com.example.demo.Entities.Car;
import com.example.demo.Entities.UserType;
import com.example.demo.Repos.UserTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService {
    @Autowired
    private UserTypeRepo repo;
    public List<UserType> GetAllCar(){
        return repo.findAll();
    }

    public void CreateUserType(UserType userType){
        repo.save(userType);
    }

    public void DeleteUserTypeById(long id){
        repo.deleteById(id);
    }

    public void UpdateCar(UserType userType){
        repo.save(userType);
    }
}
