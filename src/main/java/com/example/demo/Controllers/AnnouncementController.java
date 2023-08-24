package com.example.demo.Controllers;

import com.example.demo.Entities.Announcement;
import com.example.demo.Entities.AnnouncementStatus;
import com.example.demo.Services.AnnouncementService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/announcementController")
public class AnnouncementController {
    @Autowired
    private AnnouncementService Service;
    public AnnouncementController(AnnouncementService service){
        this.Service = service;
    }

    @GetMapping("/announcements")
    public ResponseEntity<List<Announcement>> getAnnouncements(){

        ResponseEntity<List<Announcement>> announcements = new ResponseEntity<List<Announcement>>(Service.getAllAnnouncements(), HttpStatus.OK);
        return announcements;
    }

    @PostMapping("/announcement/post")
    public ResponseEntity CreateAnnouncement(@RequestBody Announcement announcement){
        Service.updateAnnouncement(announcement);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/announcement/delete/{id}")
    public ResponseEntity DeleteAnnouncementById(long id){
        Service.deleteAnnouncementById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
