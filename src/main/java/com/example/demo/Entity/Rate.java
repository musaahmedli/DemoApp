package com.example.demo.Entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    @NotNull
    @ManyToOne
    Course RatedCourse;

    @NotNull
    @ManyToOne
    User RatedUser;

    Long Rating;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Course getRatedCourse() {
        return RatedCourse;
    }

    public void setRatedCourse(Course ratedCourse) {
        RatedCourse = ratedCourse;
    }

    public User getRatedUser() {
        return RatedUser;
    }

    public void setRatedUser(User ratedUser) {
        RatedUser = ratedUser;
    }

    public Long getRating() {
        return Rating;
    }

    public void setRating(Long rating) {
        Rating = rating;
    }
}
