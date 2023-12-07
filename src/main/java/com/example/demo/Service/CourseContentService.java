package com.example.demo.Service;

import com.example.demo.DataTransferObject.Request.GetDto.CourseContent.CourseContentGetRequestDto;
import com.example.demo.DataTransferObject.Request.PostDto.CourseContent.CourseContentPostDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CourseContentService {
    void create(CourseContentPostDto dto, MultipartFile file) throws Exception;
    List<CourseContentGetRequestDto> getAllByCourseId(long courseId) throws Exception;
    void delete(long id) throws Exception;
}
