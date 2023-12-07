package com.example.demo.ServiceImpl;

import com.example.demo.Core.FileType;
import com.example.demo.DataTransferObject.Request.PostDto.Course.CoursePostRequestDto;
import com.example.demo.DataTransferObject.Response.GetDto.Course.CourseGetAllResponseDto;
import com.example.demo.DataTransferObject.Response.GetDto.Course.CourseGetOneResponseDto;
import com.example.demo.DataTransferObject.Response.GetDto.CourseTransaction.CourseTransactionGetResponseDto;
import com.example.demo.DataTransferObject.Response.GetDto.User.UserGetResponseDto;
import com.example.demo.Entity.Course;
import com.example.demo.Entity.Rate;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.CourseMapper;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.CourseTransactionRepository;
import com.example.demo.Repository.RateRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.CourseService;
import com.example.demo.Service.CourseTransactionService;
import com.example.demo.Service.FileHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final UserRepository userRepository;
    private final CourseMapper mapper;
    private final UserMapper userMapper;
    private final FileHandlingService fileHandlingService;
    private final CourseTransactionService courseTransactionService;
    private final RateRepository rateRepository;


    @Autowired
    public CourseServiceImpl(CourseRepository repository,
                             UserRepository userRepository,
                             CourseMapper mapper,
                             UserMapper userMapper,
                             FileHandlingService fileHandlingService,
                             RateRepository rateRepository,
                             CourseTransactionService courseTransactionService)
    {
        this.repository = repository;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.userMapper = userMapper;
        this.fileHandlingService = fileHandlingService;
        this.rateRepository = rateRepository;
        this.courseTransactionService = courseTransactionService;
    }


    @Override
    public List<CourseGetAllResponseDto> getAll() throws Exception{
        List<Course> coursesFromDb = repository.findAll();

        List<CourseGetAllResponseDto> courses = new ArrayList<CourseGetAllResponseDto>();

        if(coursesFromDb.isEmpty() || coursesFromDb.size() == 0){
            throw new Exception("no courses found");
        }

        for (Course course: coursesFromDb) {

            if(course.isActive()){

                List< Rate > ratingsByCourse = rateRepository.getRatingByCourseId ( course.getId () );
                double rating = 0;
                if(ratingsByCourse != null && ratingsByCourse.size() > 0) {
                    rating = CalculateRating(ratingsByCourse);
                }
                CourseGetAllResponseDto courseRetrieved = mapper.mapToGetAllDto(course);

                UserGetResponseDto userDto = userMapper.mapToGetDto(course.getInstructor());

                List<CourseTransactionGetResponseDto> transactions = courseTransactionService.getTransactionsByCourse(course.getId());

                courseRetrieved.setInstructor(userDto);

                courseRetrieved.setRating ( rating );

                if(transactions == null || transactions.isEmpty()) {
                    courseRetrieved.setSoldCount((long)0);
                }
                else{
                    courseRetrieved.setSoldCount((long)transactions.size());
                }
                courses.add(courseRetrieved);
            }
        }

        return courses;
    }
    public double CalculateRating(List<Rate> ratings)
    {

        long container = 0;

        for ( Rate rate : ratings )
        {
            container += rate.getRating ();
        }

        double rating = container / ratings.size ();

        return rating;
    }

    @Override
    public CourseGetOneResponseDto getById(long id)throws Exception
    {

        Course course = repository.findById(id).orElseThrow();

        CourseGetOneResponseDto courseRetrieved = mapper.mapToGetOneDto(course);

        User user = course.getInstructor();

        UserGetResponseDto userDto = userMapper.mapToGetDto(user);

        courseRetrieved.setInstructor(userDto);

        return courseRetrieved;
    }

    @Override
    public List<CourseGetAllResponseDto> getCoursesByPagination(Pageable paging) {
        //List<Course> courses = repository.getCourseByPage(pageIndex*9);
        Page<Course> courses = repository.findAll(paging);
        if(courses == null){
            return null;
        }
        List<CourseGetAllResponseDto> response = new ArrayList<CourseGetAllResponseDto>();

        for (Course course : courses) {
            CourseGetAllResponseDto dto = mapper.mapToGetAllDto(course);
            response.add(dto);
        }
        return response;
    }

    @Override
    public void create(CoursePostRequestDto courseDto,
                       MultipartFile demoFile,
                       MultipartFile coverPhoto)throws Exception
    {
        if(courseDto.getInstructorId() == 0){
            throw new Exception("Instructor id is zero");
        }

        Optional<User> user = userRepository.findById(courseDto.getInstructorId());
        if(!user.isPresent()){
            throw new Exception("Instructor not found");
        }

        Course course = mapper.mapToEntity(courseDto);
        course.setInstructor(user.get());
        course.setDateCreated(LocalDate.now());
        course.setActive(true);
        course = repository.save(course);

        if (course.getId() != 0) {
            if (demoFile != null) {
                Path path = fileHandlingService.saveFileToServer(demoFile.getBytes(), demoFile.getOriginalFilename(), course.getId(), FileType.DemoVideo.toString());
                course.setDemoFilePath(path.toAbsolutePath().toString());
            }
            if(coverPhoto != null){
                Path path = fileHandlingService.saveFileToServer(coverPhoto.getBytes(),coverPhoto.getOriginalFilename(), course.getId(),FileType.CoverPhoto.toString());
                course.setCoverPhotoPath(path.toAbsolutePath().toString());
            }
            repository.save(course);
        }
    }


    @Override
    public void delete(long id) throws Exception{
        Course course = repository.findById(id).orElseThrow();
        course.setActive(false);
        repository.save(course);

    }
}
