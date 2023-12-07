package com.example.demo.Repository;

import com.example.demo.Entity.UserCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface UserCertificateRepository extends JpaRepository<UserCertificate,Long> {
    @Query("select uc from UserCertificate uc where uc.User.Id = :user_id and uc.Active = TRUE")
    List<UserCertificate> getUserCertificates(@Param(value = "user_id") Long userId);
}
