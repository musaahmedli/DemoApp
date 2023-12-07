package com.example.demo.Controller;

import com.example.demo.Service.CourseTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/CourseTransaction")
public class CourseTransactionController {
    private final CourseTransactionService courseTransactionService;

    @Autowired
    public CourseTransactionController(CourseTransactionService courseTransactionService) {
        this.courseTransactionService = courseTransactionService;
    }

}
