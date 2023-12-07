package com.example.demo.DataTransferObject.Request.PostDto.Rate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatePostDto
{
	Long Rating;
	Long CourseId;
	Long UserId;

	public Long getRating ( )
	{

		return Rating;
	}

	public void setRating ( Long rating )
	{

		Rating = rating;
	}

	public Long getCourseId ( )
	{

		return CourseId;
	}

	public void setCourseId ( Long courseId )
	{

		CourseId = courseId;
	}

	public Long getUserId ( )
	{

		return UserId;
	}

	public void setUserId ( Long userId )
	{

		UserId = userId;
	}

}
