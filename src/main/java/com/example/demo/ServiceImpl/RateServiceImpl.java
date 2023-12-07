package com.example.demo.ServiceImpl;

import com.example.demo.DataTransferObject.Request.PostDto.Rate.RatePostDto;
import com.example.demo.Entity.Course;
import com.example.demo.Entity.Rate;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.RateMapper;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.RateRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RateServiceImpl implements RateService
{
	private final RateRepository rateRepository;
	private final RateMapper rateMapper;
	private final UserRepository userRepository;
	private final CourseRepository courseRepository;
	@Autowired
	public RateServiceImpl(RateRepository rateRepository,
												 RateMapper rateMapper,
												 UserRepository userRepository,
												 CourseRepository courseRepository)
	{
		this.rateRepository = rateRepository;
		this.rateMapper = rateMapper;
		this.userRepository = userRepository;
		this.courseRepository = courseRepository;
	}
	@Override
	public void submitRating ( RatePostDto dto ) throws Exception
	{
		if(dto == null){
			throw new Exception ( "Rate dto is null" );
		}
		if(dto.getUserId () == null || dto.getUserId () == 0)
		{
			throw new Exception ( "User id in Rate dto is null or Zero" );
		}
		if(dto.getCourseId () == null || dto.getCourseId () == 0)
		{
			throw new Exception ( "Course id in Rate dto is null or Zero" );
		}

		User user = userRepository.findById ( dto.getUserId () ).orElseThrow ();

		Course course = courseRepository.findById (  dto.getCourseId () ).orElseThrow ();

		List<Rate> userRatedThisCourse = rateRepository.getRatingByCourseAndUserId ( course.getId (),user.getId () );

		if(!userRatedThisCourse.isEmpty () || userRatedThisCourse.size () > 0){
			throw new Exception ( "User has rated this course before" );

		}

		Rate rate =rateMapper.mapToEntity ( dto );

		rate.setRatedUser ( user );

		rate.setRatedCourse ( course );

		rateRepository.save ( rate );

	}

}
