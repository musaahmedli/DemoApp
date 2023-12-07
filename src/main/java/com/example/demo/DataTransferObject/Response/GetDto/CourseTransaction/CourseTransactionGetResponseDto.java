package com.example.demo.DataTransferObject.Response.GetDto.CourseTransaction;

import com.example.demo.DataTransferObject.Response.GetDto.Course.CourseGetOneResponseDto;
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
public class CourseTransactionGetResponseDto
{
	Long Id;
	UserGetResponseDto TransactedUser;
	CourseGetOneResponseDto TransactedCourse;

	public Long getId ( )
	{

		return Id;
	}

	public void setId ( Long id )
	{

		Id = id;
	}

	public UserGetResponseDto getTransactedUser ( )
	{

		return TransactedUser;
	}

	public void setTransactedUser ( UserGetResponseDto transactedUser )
	{

		TransactedUser = transactedUser;
	}

	public CourseGetOneResponseDto getTransactedCourse ( )
	{

		return TransactedCourse;
	}

	public void setTransactedCourse ( CourseGetOneResponseDto transactedCourse )
	{

		TransactedCourse = transactedCourse;
	}

}
