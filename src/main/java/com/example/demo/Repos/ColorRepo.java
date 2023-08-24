package com.example.demo.Repos;

import com.example.demo.Entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepo extends JpaRepository<Color,Long> {
}
