package com.example.demo.Controller;

import com.example.demo.Core.Auth;
import com.example.demo.Core.CustomResponse.ResponseHandler;
import com.example.demo.DataTransferObject.Request.PostDto.CourseContentComment.CourseContentCommentPostDto;
import com.example.demo.Service.CourseContentCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/course-content-comments")
public class CourseContentCommentController {

    private final CourseContentCommentService courseContentCommentService;

    @Autowired
    public CourseContentCommentController(CourseContentCommentService courseContentCommentService) {
        this.courseContentCommentService = courseContentCommentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> submitUserComment(String authorization, @RequestBody CourseContentCommentPostDto comment) {

        try {
            Auth.authorizationIsValid(authorization,false);
            courseContentCommentService.submitComment(comment);
            return ResponseHandler.generateResponse("comment submitted successfully", HttpStatus.OK, null);

        } catch (Exception exception) {
            return ResponseHandler.generateResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
