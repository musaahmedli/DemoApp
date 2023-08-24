package com.example.demo.Controllers;

import com.example.demo.Entities.Announcement;
import com.example.demo.Entities.AnnouncementStatus;
import com.example.demo.Services.AnnouncementService;
import com.example.demo.Services.AnnouncementStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/announcementStatusController")
public class AnnouncementStatusController {
    private AnnouncementStatusService Service;
    public AnnouncementStatusController(AnnouncementStatusService service){
        this.Service = service;
    }

    @GetMapping("/announcements")
    public ResponseEntity<List<AnnouncementStatus>> GetAllAnnouncementStatus(){
        return new ResponseEntity<List<AnnouncementStatus>>(Service.GetAllAnnouncementStatus(), HttpStatus.OK);
    }

    @PostMapping("/announcement/post")
    public ResponseEntity<AnnouncementStatus> CreateAnnouncementStatus(@RequestBody AnnouncementStatus announcementStatus){
        Service.CreateAnnouncementStatus(announcementStatus);
        return new ResponseEntity<AnnouncementStatus>(announcementStatus,HttpStatus.OK);
    }
}
