package com.example.demo.Services;

import com.example.demo.Entities.Announcement;
import com.example.demo.Repos.AnnouncementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepo repo;

    public List<Announcement> getAllAnnouncements(){

       return repo.findAll();

    }
    public void deleteAnnouncementById(long id){

        repo.deleteById(id);

    }

    public void updateAnnouncement(Announcement announcement){

        repo.saveAndFlush(announcement);
    }



}
