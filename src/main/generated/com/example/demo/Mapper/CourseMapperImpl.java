package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.Course.CoursePostRequestDto;
import com.example.demo.DataTransferObject.Response.GetDto.Course.CourseGetAllResponseDto;
import com.example.demo.DataTransferObject.Response.GetDto.Course.CourseGetOneResponseDto;
import com.example.demo.Entity.Course;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-07T15:15:22+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Course mapToEntity(CoursePostRequestDto courseDto) {
        if ( courseDto == null ) {
            return null;
        }

        Course course = new Course();

        course.setName( courseDto.getName() );
        course.setTopic( courseDto.getTopic() );
        course.setPrice( courseDto.getPrice() );
        course.setLevel( courseDto.getLevel() );
        course.setDescription( courseDto.getDescription() );

        return course;
    }

    @Override
    public CourseGetOneResponseDto mapToGetOneDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseGetOneResponseDto courseGetOneResponseDto = new CourseGetOneResponseDto();

        courseGetOneResponseDto.setId( course.getId() );
        courseGetOneResponseDto.setName( course.getName() );
        courseGetOneResponseDto.setInstructor( userMapper.mapToGetDto( course.getInstructor() ) );

        return courseGetOneResponseDto;
    }

    @Override
    public CourseGetAllResponseDto mapToGetAllDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseGetAllResponseDto courseGetAllResponseDto = new CourseGetAllResponseDto();

        courseGetAllResponseDto.setId( course.getId() );
        courseGetAllResponseDto.setName( course.getName() );
        courseGetAllResponseDto.setTopic( course.getTopic() );
        courseGetAllResponseDto.setInstructor( userMapper.mapToGetDto( course.getInstructor() ) );
        courseGetAllResponseDto.setPrice( course.getPrice() );

        return courseGetAllResponseDto;
    }
}
