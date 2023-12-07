package com.example.demo.Service;

import com.example.demo.DataTransferObject.Request.PostDto.CourseTransaction.CourseTransactionPostDto;
import com.example.demo.DataTransferObject.Response.GetDto.CourseTransaction.CourseTransactionGetResponseDto;
import com.example.demo.Entity.CourseTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseTransactionService
{
	List<CourseTransactionGetResponseDto> getTransactionsByCourse(Long courseId) throws Exception;
	List<CourseTransactionGetResponseDto> getUserTransactions(Long userId) throws Exception;
	void saveTransaction(CourseTransactionPostDto transaction) throws Exception;
}
