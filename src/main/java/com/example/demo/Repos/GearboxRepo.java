package com.example.demo.Repos;

import com.example.demo.Entities.Gearbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GearboxRepo extends JpaRepository<Gearbox,Long> {
}
