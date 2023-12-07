package com.example.demo.Repository;

import com.example.demo.Entity.CourseContentComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseContentCommentRepository extends JpaRepository<CourseContentComment,Long> {

}
