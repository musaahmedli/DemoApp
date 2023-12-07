package com.example.demo.DataTransferObject.Request.PostDto.Certificate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificatePostDto
{
	MultipartFile Certificate;
	Long CourseId;

	public MultipartFile getCertificate ( )
	{

		return Certificate;
	}

	public void setCertificate ( MultipartFile certificate )
	{

		Certificate = certificate;
	}

	public Long getCourseId ( )
	{

		return CourseId;
	}

	public void setCourseId ( Long courseId )
	{

		CourseId = courseId;
	}

}
