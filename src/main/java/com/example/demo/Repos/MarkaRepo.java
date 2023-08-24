package com.example.demo.Repos;

import com.example.demo.Entities.Marka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkaRepo extends JpaRepository<Marka,Long> {
}
