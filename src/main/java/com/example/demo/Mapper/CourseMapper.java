package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.Course.CoursePostRequestDto;
import com.example.demo.DataTransferObject.Response.GetDto.Course.CourseGetAllResponseDto;
import com.example.demo.DataTransferObject.Response.GetDto.Course.CourseGetOneResponseDto;
import com.example.demo.Entity.Course;
import org.mapstruct.*;

@Mapper(uses = {UserMapper.class,CourseContentMapper.class},
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CourseMapper {
    Course mapToEntity(CoursePostRequestDto courseDto);
    CourseGetOneResponseDto mapToGetOneDto(Course course);
    CourseGetAllResponseDto mapToGetAllDto(Course course);
}
