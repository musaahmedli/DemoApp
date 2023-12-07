package com.example.demo.Entity;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    @NotNull
    @ManyToOne
    User transactedUser;

    @NotNull
    @ManyToOne
    Course TransactedCourse;

    boolean Active;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public User getTransactedUser() {
        return transactedUser;
    }

    public void setTransactedUser(User transactedUser) {
        this.transactedUser = transactedUser;
    }

    public Course getTransactedCourse() {
        return TransactedCourse;
    }

    public void setTransactedCourse(Course transactedCourse) {
        TransactedCourse = transactedCourse;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }
}
