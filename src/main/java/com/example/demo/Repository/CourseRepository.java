package com.example.demo.Repository;

import com.example.demo.Entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query(nativeQuery = true,value = "select * from course limit 9 offset ?1 ")
    List<Course> getCourseByPage(@Param(value = "skipCount") int skipCount);
}
