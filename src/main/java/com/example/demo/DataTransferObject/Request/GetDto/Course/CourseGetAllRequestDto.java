package com.example.demo.DataTransferObject.Request.GetDto.Course;

import com.example.demo.DataTransferObject.Response.GetDto.User.UserGetResponseDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseGetAllRequestDto {

    String Name;
    double Price;
    String Topic;
    UserGetResponseDto InstructorDto;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public UserGetResponseDto getInstructorDto() {
        return InstructorDto;
    }

    public void setInstructorDto(UserGetResponseDto instructorDto) {
        InstructorDto = instructorDto;
    }
}
