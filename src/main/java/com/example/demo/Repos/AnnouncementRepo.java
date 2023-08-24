package com.example.demo.Repos;

import com.example.demo.Entities.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement,Long> {
}
