package com.example.demo.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
