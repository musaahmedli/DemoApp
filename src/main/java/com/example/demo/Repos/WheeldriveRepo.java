package com.example.demo.Repos;

import com.example.demo.Entities.Wheeldrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheeldriveRepo extends JpaRepository<Wheeldrive,Long> {
}
