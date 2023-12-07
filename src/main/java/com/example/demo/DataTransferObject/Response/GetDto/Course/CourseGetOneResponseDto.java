package com.example.demo.DataTransferObject.Response.GetDto.Course;


import com.example.demo.DataTransferObject.Response.GetDto.CourseContentDto.CourseContentGetDto;
import com.example.demo.DataTransferObject.Response.GetDto.User.UserGetResponseDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseGetOneResponseDto {
    Long Id;
    String Name;
    UserGetResponseDto Instructor;
    List<CourseContentGetDto> CourseContents;

    public List<CourseContentGetDto> getCourseContents() {
        return CourseContents;
    }

    public void setCourseContents(List<CourseContentGetDto> courseContents) {
        CourseContents = courseContents;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public UserGetResponseDto getInstructor() {
        return Instructor;
    }

    public void setInstructor(UserGetResponseDto instructor) {
        Instructor = instructor;
    }
}
