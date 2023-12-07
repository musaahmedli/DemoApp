package com.example.demo.Entity;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupportCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    @NotNull
    String FullName;

    @NotNull @Email
    String Email;

    @NotNull
    String Description;

    @NotNull
    String Status;

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

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
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
}


