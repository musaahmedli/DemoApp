package com.example.demo.Repos;

import com.example.demo.Entities.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepo extends JpaRepository<Market,Long> {
}
