package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.GetDto.CourseContent.CourseContentGetRequestDto;
import com.example.demo.DataTransferObject.Request.PostDto.CourseContent.CourseContentPostDto;
import com.example.demo.Entity.CourseContent;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-07T15:15:22+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class CourseContentMapperImpl implements CourseContentMapper {

    @Override
    public CourseContent mapToEntity(CourseContentPostDto dto) {
        if ( dto == null ) {
            return null;
        }

        CourseContent courseContent = new CourseContent();

        courseContent.setName( dto.getName() );
        courseContent.setDescription( dto.getDescription() );

        return courseContent;
    }

    @Override
    public CourseContentGetRequestDto mapToGetDto(CourseContent entity) {
        if ( entity == null ) {
            return null;
        }

        CourseContentGetRequestDto courseContentGetRequestDto = new CourseContentGetRequestDto();

        courseContentGetRequestDto.setId( entity.getId() );
        courseContentGetRequestDto.setName( entity.getName() );
        courseContentGetRequestDto.setDescription( entity.getDescription() );
        courseContentGetRequestDto.setMediaPath( entity.getMediaPath() );

        return courseContentGetRequestDto;
    }
}
