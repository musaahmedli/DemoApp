package com.example.demo.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Entity
@Data
@NoArgsConstructor
@Table
public class Car {
    @Id
    @GeneratedValue
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
