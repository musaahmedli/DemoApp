package com.example.demo.Entity;

import com.example.demo.Core.AuthProvider;
import com.example.demo.Core.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    @NotNull
    String Email;


    String Password;

    String MetaUID;

    String Role;

    @Enumerated(EnumType.STRING)
    AuthProvider AuthProvider;

    String FirstName;


    String LastName;

    String PhoneNumber;

    String Biography;

    boolean Active;

    @NotNull
    LocalDate DateCreated;

    LocalDate DateUpdated;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMetaUID() {
        return MetaUID;
    }

    public void setMetaUID(String metaUID) {
        MetaUID = metaUID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getBiography() {
        return Biography;
    }

    public void setBiography(String biography) {
        Biography = biography;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public LocalDate getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        DateCreated = dateCreated;
    }

    public LocalDate getDateUpdated() {
        return DateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        DateUpdated = dateUpdated;
    }


    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public com.example.demo.Core.AuthProvider getAuthProvider() {
        return AuthProvider;
    }

    public void setAuthProvider(com.example.demo.Core.AuthProvider authProvider) {
        AuthProvider = authProvider;
    }
}
