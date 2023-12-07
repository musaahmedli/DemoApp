package com.example.demo.ServiceImpl;

import com.example.demo.DataTransferObject.Request.PostDto.CourseTransaction.CourseTransactionPostDto;
import com.example.demo.DataTransferObject.Response.GetDto.CourseTransaction.CourseTransactionGetResponseDto;
import com.example.demo.Entity.Course;
import com.example.demo.Entity.CourseTransaction;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.CourseTransactionMapper;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.CourseTransactionRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.CourseTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class CourseTransactionServiceImpl implements CourseTransactionService
{
	private final CourseTransactionMapper courseTransactionMapper;
	private final CourseTransactionRepository courseTransactionRepository;

	private final UserRepository userRepository;
	private final CourseRepository courseRepository;
	@Autowired
	public CourseTransactionServiceImpl(CourseTransactionMapper courseTransactionMapper,
										CourseTransactionRepository courseTransactionRepository,
										CourseRepository courseRepository,
										UserRepository userRepository){
		this.courseTransactionMapper = courseTransactionMapper;
		this.courseTransactionRepository = courseTransactionRepository;
		this.courseRepository = courseRepository;
		this.userRepository = userRepository;
	}
	@Override
	public List<CourseTransactionGetResponseDto> getTransactionsByCourse(Long courseId) throws Exception
	{
		Optional<Course> courseOptional = courseRepository.findById(courseId);
		if(!courseOptional.isPresent()){
			throw new NoSuchElementException("Course not found in db");
		}

		List<CourseTransaction> transactions = courseTransactionRepository.getTransactionByCourse(courseId);

		if(transactions.isEmpty() || transactions.size() == 0){
			return null;
		}
		List<CourseTransactionGetResponseDto> finalTransactions = courseTransactionMapper.mapToGetListDto(transactions);

		return finalTransactions;
	}

	@Override
	public List<CourseTransactionGetResponseDto> getUserTransactions(Long userId) throws Exception
	{
		Optional<User> userOptional = userRepository.findById(userId);
		if(!userOptional.isPresent()){
			throw new NoSuchElementException("user not found in database");
		}

		List<CourseTransaction> transactions = courseTransactionRepository.getUserTransactions(userId);

		if(transactions.isEmpty() || transactions.size() == 0){
			return null;
		}
		List<CourseTransactionGetResponseDto> finalTransactions = courseTransactionMapper.mapToGetListDto(transactions);

		return finalTransactions;
	}

	@Override
	public void saveTransaction(CourseTransactionPostDto transaction) throws Exception {
		if(transaction == null){
			throw new NullPointerException("transaction is null");
		}
		long courseId = transaction.getCourseId();
		long userId = transaction.getUserId();

		if(transaction.getCourseId() == null || transaction.getCourseId() == 0){
			throw new Exception("courseId in transaction dto is null");
		}

		if(transaction.getUserId() == null || transaction.getUserId() == 0){
			throw new Exception("UserId in transaction dto is null");
		}

		Optional<Course> course = courseRepository.findById(courseId);
		if(!course.isPresent()){
			throw new NoSuchElementException("course not found");
		}

		User user = userRepository.findActiveUserById(userId);
		if(user == null){
			throw new NoSuchElementException("user not found");
		}

		CourseTransaction courseTransaction = courseTransactionMapper.mapToEntity(transaction);
		courseTransaction.setTransactedUser(user);
		courseTransaction.setTransactedCourse(course.get());

		courseTransactionRepository.save(courseTransaction);
	}

}
