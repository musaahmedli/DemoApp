package com.example.demo.Entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private boolean isActive;
    @ManyToOne
    private Market market;
    @ManyToOne
    private Model model;
    @ManyToOne
    private Wheeldrive wheeldrive;
    @ManyToOne
    private Color color;
    @ManyToOne
    private Category category;
    @ManyToOne
    private FuelType fuelType;
    @ManyToOne
    private Marka marka;
    @ManyToOne
    private Gearbox gearbox;
    private int seatCount;
    private long mileage;
    private long hp;
    private int ownerCount;
    private long engineVolume;
}
