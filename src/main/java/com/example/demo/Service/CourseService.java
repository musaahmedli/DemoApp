package com.example.demo.Service;

import com.example.demo.DataTransferObject.Request.PostDto.Course.CoursePostRequestDto;
import com.example.demo.DataTransferObject.Response.GetDto.Course.CourseGetAllResponseDto;
import com.example.demo.DataTransferObject.Response.GetDto.Course.CourseGetOneResponseDto;
import org.aspectj.weaver.bcel.ExceptionRange;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CourseService {
    List<CourseGetAllResponseDto> getAll() throws Exception;
    CourseGetOneResponseDto getById(long id) throws Exception;
    List<CourseGetAllResponseDto> getCoursesByPagination(Pageable paging);
    void create(CoursePostRequestDto courseDto, MultipartFile demoFile,MultipartFile coverPhoto) throws Exception;
    void delete(long id) throws Exception;
}
