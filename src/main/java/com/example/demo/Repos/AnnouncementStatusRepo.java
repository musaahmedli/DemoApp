package com.example.demo.Repos;

import com.example.demo.Entities.AnnouncementStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementStatusRepo extends JpaRepository<AnnouncementStatus,Long> {
}
