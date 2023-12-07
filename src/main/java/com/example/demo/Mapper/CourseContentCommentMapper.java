package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.CourseContentComment.CourseContentCommentPostDto;
import com.example.demo.Entity.CourseContentComment;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CourseContentCommentMapper {

    CourseContentComment mapToEntity(CourseContentCommentPostDto dto);
    CourseContentCommentPostDto mapToPostDto(CourseContentComment entity);

}
