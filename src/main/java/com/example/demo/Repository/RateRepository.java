package com.example.demo.Repository;

import com.example.demo.Entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepository extends JpaRepository< Rate,Long >
{
	@Query("SELECT r FROM Rate r WHERE(r.RatedCourse.Id = :course_id) and (r.RatedUser.Id = :user_id)")
	List<Rate> getRatingByCourseAndUserId( @Param ( value = "course_id") Long courseId,
																				 @Param ( value = "user_id") Long userId);

	@Query("select r from Rate r where r.RatedCourse.Id = :course_id")
	List<Rate> getRatingByCourseId(@Param ( value = "course_id")Long courseId);
}
