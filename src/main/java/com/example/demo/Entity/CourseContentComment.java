package com.example.demo.Entity;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Table
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseContentComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    @NotNull
    String Comment;

    @NotNull
    @ManyToOne
    CourseContent CommentedCourseContent;

    @NotNull
    @ManyToOne
    User CommentedUser;

    boolean Active;

    LocalDate DateCommented;

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

    public CourseContent getCommentedCourseContent() {
        return CommentedCourseContent;
    }

    public void setCommentedCourseContent(CourseContent commentedCourseContent) {
        CommentedCourseContent = commentedCourseContent;
    }

    public User getCommentedUser() {
        return CommentedUser;
    }

    public void setCommentedUser(User commentedUser) {
        CommentedUser = commentedUser;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public LocalDate getDateCommented() {
        return DateCommented;
    }

    public void setDateCommented(LocalDate dateCommented) {
        DateCommented = dateCommented;
    }

    public LocalDate getDateUpdated() {
        return DateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        DateUpdated = dateUpdated;
    }
}
