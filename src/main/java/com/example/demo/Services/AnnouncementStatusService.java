package com.example.demo.Services;

import com.example.demo.Entities.AnnouncementStatus;
import com.example.demo.Repos.AnnouncementStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementStatusService {
    @Autowired
    private AnnouncementStatusRepo repo;
    public List<AnnouncementStatus> GetAllAnnouncementStatus(){
        return repo.findAll();
    }

    public void CreateAnnouncementStatus(AnnouncementStatus announcementStatus){
        repo.save(announcementStatus);
    }

    public void DeleteAnnouncementStatusById(long id){
        repo.deleteById(id);
    }

    public void UpdateAnnouncementStatus(AnnouncementStatus announcementStatus){
        repo.save(announcementStatus);
    }
}
