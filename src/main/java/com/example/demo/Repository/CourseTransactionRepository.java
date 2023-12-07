package com.example.demo.Repository;

import com.example.demo.Entity.CourseTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseTransactionRepository extends JpaRepository< CourseTransaction,Long >
{
	@Query("select ct from CourseTransaction ct where ct.transactedUser.Id = :user_id and ct.Active = TRUE")
	List<CourseTransaction> getUserTransactions(@Param ( value = "user_id") Long userId);

	@Query("select ct from CourseTransaction ct where ct.TransactedCourse.Id = :course_id and ct.Active = TRUE")
	List<CourseTransaction> getTransactionByCourse(@Param ( value = "course_id")Long courseId);
}
