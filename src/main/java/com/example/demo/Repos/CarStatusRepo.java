package com.example.demo.Repos;

import com.example.demo.Entities.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarStatusRepo extends JpaRepository<CarStatus,Long> {
}
