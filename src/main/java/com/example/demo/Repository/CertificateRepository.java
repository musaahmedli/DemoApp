package com.example.demo.Repository;

import com.example.demo.Entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate,Long> {
    @Query(nativeQuery = true ,value = "select * from Certificate c where c.course_id = :course_id and c.Active = TRUE Limit 0,1")
    Certificate getCertificateByCourse(@Param(value = "course_id") Long courseId);
}
