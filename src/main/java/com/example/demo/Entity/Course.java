package com.example.demo.Entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    @NotNull
    String Name;

    String Topic;

    @NotNull
    double Price;

    String Level;

    @NotNull
    @ManyToOne
    User Instructor;



    String DemoFilePath;

    String CoverPhotoPath;

    @NotNull
    String Description;

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public User getInstructor() {
        return Instructor;
    }

    public void setInstructor(User instructor) {
        Instructor = instructor;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

    public String getDemoFilePath() {

        return DemoFilePath;
    }

    public void setDemoFilePath(String demoFilePath) {

        DemoFilePath = demoFilePath;
    }

    public String getCoverPhotoPath() {

        return CoverPhotoPath;
    }

    public void setCoverPhotoPath(String coverPhotoPath) {

        CoverPhotoPath = coverPhotoPath;
    }

}
