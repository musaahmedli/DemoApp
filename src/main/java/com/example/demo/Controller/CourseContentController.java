package com.example.demo.Controller;

import com.example.demo.Core.CustomResponse.ResponseHandler;
import com.example.demo.DataTransferObject.Request.GetDto.CourseContent.CourseContentGetRequestDto;
import com.example.demo.DataTransferObject.Request.PostDto.CourseContent.CourseContentPostDto;
import com.example.demo.Service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/CourseContents")
public class CourseContentController {
    private final CourseContentService courseContentService;
    @Autowired
    public CourseContentController(CourseContentService courseContentService){
        this.courseContentService = courseContentService;
    }
    @PostMapping("/save")
    public ResponseEntity<Object> createCourseContent(String authorization, CourseContentPostDto content,@RequestPart(name = "file",required = false) MultipartFile file){
        try{

            courseContentService.create(content,file);
            return ResponseHandler.generateResponse("content created successfully",HttpStatus.OK,null);
        }
        catch (Exception ex){
            return ResponseHandler.generateResponse(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/getByCourseId")
    public ResponseEntity<Object> getContentsByCourseId(@PathVariable Long courseId) throws Exception{
        try {
            List<CourseContentGetRequestDto> response = courseContentService.getAllByCourseId(courseId);
            return ResponseHandler.generateResponse(null,HttpStatus.OK,response);
        }
        catch (Exception exception){
            return ResponseHandler.generateResponse(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }

    }
}
