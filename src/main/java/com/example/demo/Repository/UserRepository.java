package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	@Query("SELECT u FROM User u WHERE u.Active = TRUE")
	List<User> findAllActiveUsers();

	@Query("SELECT u FROM User u WHERE u.Id = :user_id and u.Active = TRUE")
	User findActiveUserById(@Param(value = "user_id") long id);

	@Query("Select u from User u where u.Email = :email and u.Active = TRUE")
	User findByEmail(@Param(value = "email") String Email);
}
