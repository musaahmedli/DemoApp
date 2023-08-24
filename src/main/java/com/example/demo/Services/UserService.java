package com.example.demo.Services;

import com.example.demo.Entities.User;
import com.example.demo.Entities.UserType;
import com.example.demo.Repos.UserRepo;
import com.example.demo.Repos.UserTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    public List<User> GetAllUser(){
        return repo.findAll();
    }

    public void CreateUser(User user){
        repo.save(user);
    }

    public void DeleteUserById(long id){
        repo.deleteById(id);
    }

    public void UpdateUser(User user){
        repo.save(user);
    }
}
