package com.example.demo.DataTransferObject.Response.GetDto.Course;

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
public class CourseGetAllResponseDto {
    Long Id;
    String Name;
    String Topic;
    double Price;
    UserGetResponseDto Instructor;
    Long SoldCount;
    double Rating;

    public double getRating ( )
    {

        return Rating;
    }

    public void setRating ( double rating )
    {

        Rating = rating;
    }

    public Long getSoldCount ( )
    {

        return SoldCount;
    }

    public void setSoldCount ( Long soldCount )
    {

        SoldCount = soldCount;
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

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public UserGetResponseDto getInstructor() {
        return Instructor;
    }

    public void setInstructor(UserGetResponseDto instructor) {
        Instructor = instructor;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
