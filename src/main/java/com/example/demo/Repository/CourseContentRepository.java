package com.example.demo.Repository;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.CourseContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseContentRepository extends JpaRepository<CourseContent,Long> {
    @Query("SELECT c FROM CourseContent c WHERE(c.Course.Id = :course_id) and c.Active = TRUE")
    List<CourseContent> getAllByCourseId(@Param(value = "course_id") Long courseId);
}
