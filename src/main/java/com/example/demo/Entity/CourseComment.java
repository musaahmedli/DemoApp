package com.example.demo.Entity;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    @NotNull
    String Comment;

    @NotNull
    @ManyToOne
    User CommentedUser;

    @NotNull
    @ManyToOne
    Course CommentedCourse;

    boolean Active;

    LocalDate DateFirstCommented;

    LocalDate DateUpdated;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public User getCommentedUser() {
        return CommentedUser;
    }

    public void setCommentedUser(User commentedUser) {
        this.CommentedUser = commentedUser;
    }

    public Course getCommentedCourse() {
        return CommentedCourse;
    }

    public void setCommentedCourse(Course commentedCourse) {
        CommentedCourse = commentedCourse;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public LocalDate getDateFirstCommented() {
        return DateFirstCommented;
    }

    public void setDateFirstCommented(LocalDate dateFirstCommented) {
        DateFirstCommented = dateFirstCommented;
    }

    public LocalDate getDateUpdated() {
        return DateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        DateUpdated = dateUpdated;
    }
}
