package com.example.demo.Repos;

import com.example.demo.Entities.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelTypeRepo extends JpaRepository<FuelType,Long> {
}
