package com.example.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
@Table
public class Market {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private boolean isActive;
}
