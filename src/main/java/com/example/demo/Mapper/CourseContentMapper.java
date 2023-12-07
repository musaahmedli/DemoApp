package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.GetDto.CourseContent.CourseContentGetRequestDto;
import com.example.demo.DataTransferObject.Request.PostDto.CourseContent.CourseContentPostDto;
import com.example.demo.Entity.CourseContent;
import org.mapstruct.*;
@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CourseContentMapper {
    CourseContent mapToEntity(CourseContentPostDto dto);
    CourseContentGetRequestDto mapToGetDto(CourseContent entity);
}
