package com.example.demo.Entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @ManyToOne
    Certificate Certificate;

    @ManyToOne
    User User;

    boolean Active;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public com.example.demo.Entity.Certificate getCertificate() {
        return Certificate;
    }

    public void setCertificate(com.example.demo.Entity.Certificate certificate) {
        Certificate = certificate;
    }

    public com.example.demo.Entity.User getUser() {
        return User;
    }

    public void setUser(com.example.demo.Entity.User user) {
        User = user;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }
}
