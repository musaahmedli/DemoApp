package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private boolean isActive;
    private String price;
    @ManyToOne
    private Currency currency;
    @ManyToOne
    private City city;
    private Date dateAdded;
    @ManyToOne
    private AnnouncementStatus announcementStatus;
    @ManyToOne
    private User user;
}
