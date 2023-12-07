package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.CourseContentComment.CourseContentCommentPostDto;
import com.example.demo.Entity.CourseContentComment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-07T15:15:22+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class CourseContentCommentMapperImpl implements CourseContentCommentMapper {

    @Override
    public CourseContentComment mapToEntity(CourseContentCommentPostDto dto) {
        if ( dto == null ) {
            return null;
        }

        CourseContentComment courseContentComment = new CourseContentComment();

        courseContentComment.setComment( dto.getComment() );

        return courseContentComment;
    }

    @Override
    public CourseContentCommentPostDto mapToPostDto(CourseContentComment entity) {
        if ( entity == null ) {
            return null;
        }

        CourseContentCommentPostDto courseContentCommentPostDto = new CourseContentCommentPostDto();

        courseContentCommentPostDto.setComment( entity.getComment() );

        return courseContentCommentPostDto;
    }
}
