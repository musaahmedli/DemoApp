package com.example.demo.Repos;

import com.example.demo.Entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepo extends JpaRepository<UserType,Long> {
}
