package com.example.demo.Controller;

import com.example.demo.Core.CustomResponse.ResponseHandler;
import com.example.demo.DataTransferObject.Request.PostDto.Course.CoursePostRequestDto;
import com.example.demo.DataTransferObject.Response.GetDto.Course.CourseGetAllResponseDto;
import com.example.demo.DataTransferObject.Response.GetDto.Course.CourseGetOneResponseDto;

import com.example.demo.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/Course")
public class CourseController {

    private final CourseService service;
    @Autowired
    public CourseController(CourseService service){
        this.service = service;
    }

    @GetMapping("/courseById")
    public ResponseEntity<Object> getCourseById(@PathVariable long id){
        try {
            CourseGetOneResponseDto course = service.getById(id);
            return ResponseHandler.generateResponse("success",HttpStatus.OK,course);
        }
        catch (Exception exception){
            return ResponseHandler.generateResponse(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/coursesByPage/{pageIndex}")
    public ResponseEntity<Object> getCoursesPagination(@PathVariable int pageIndex){
//        List<CourseGetAllResponseDto> response = service.getCoursesByPagination(pageIndex);
//        Integer count = 0;
//        if(response != null || response.size()>0){
//            count = response.size();
//        }
        Pageable paging = PageRequest.of(pageIndex,9);
        List<CourseGetAllResponseDto> response = service.getCoursesByPagination(paging);
        return ResponseHandler.generateResponse("row count - " + response.size() ,HttpStatus.OK,response);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllCourses(){
        try {
            List<CourseGetAllResponseDto> courses = service.getAll();
            return ResponseHandler.generateResponse(null,HttpStatus.OK,courses);
        }
        catch (Exception exception) {
            return ResponseHandler.generateResponse(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createCourse(@RequestPart(name = "demoFile",required = false) MultipartFile demoFile,
                                               @RequestPart(name = "coverPhoto",required = false) MultipartFile coverPhoto,
                                               CoursePostRequestDto courseDto){
        try {
            service.create(courseDto, demoFile, coverPhoto);
            return ResponseHandler.generateResponse("course created Successfully",HttpStatus.OK,null);
        }
        catch (Exception exception){
            return ResponseHandler.generateResponse(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCourse(@RequestParam long id){
        try {
            CourseGetOneResponseDto courseDto = service.getById(id);
            service.delete(id);
            return ResponseHandler.generateResponse("success",HttpStatus.OK,null);
        }
        catch (Exception exception){
            return ResponseHandler.generateResponse(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

}
