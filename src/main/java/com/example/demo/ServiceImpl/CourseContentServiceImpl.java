package com.example.demo.ServiceImpl;

import com.example.demo.Core.FileType;
import com.example.demo.DataTransferObject.Request.GetDto.CourseContent.CourseContentGetRequestDto;
import com.example.demo.DataTransferObject.Request.PostDto.CourseContent.CourseContentPostDto;
import com.example.demo.Entity.Course;
import com.example.demo.Entity.CourseContent;
import com.example.demo.Mapper.CourseContentMapper;
import com.example.demo.Repository.CourseContentRepository;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Service.CourseContentService;
import com.example.demo.Service.FileHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseContentServiceImpl implements CourseContentService {

    private final CourseContentRepository repository;
    private final CourseContentMapper mapper;
    private final CourseRepository courseRepository;
    private final FileHandlingService fileHandlingService;
    @Autowired
    public CourseContentServiceImpl(CourseContentRepository repository,
                                    CourseContentMapper mapper,
                                    CourseRepository courseRepository,
                                    FileHandlingService fileHandlingService){
        this.repository = repository;
        this.mapper = mapper;
        this.courseRepository = courseRepository;
        this.fileHandlingService = fileHandlingService;
    }
    @Override
    public void create(CourseContentPostDto dto, MultipartFile file) throws Exception{
        if(dto == null){
            throw new Exception("dto is null");
        }
        if(dto.getCourseId() == 0){
            throw new Exception("courseid is zero");
        }

        CourseContent entity = mapper.mapToEntity(dto);
        long courseId = dto.getCourseId();

        Optional<Course> course = courseRepository.findById(courseId);

        if(!course.isPresent()){
            throw new Exception("course not found");
        }
        if(file != null) {
            Path path = fileHandlingService.saveFileToServer(file.getBytes(),
                    file.getOriginalFilename(),
                    dto.getCourseId(),
                    FileType.Content.toString());
            entity.setMediaPath(path.toAbsolutePath().toString());
        }
        entity.setCourse(course.get());
        entity.setDateCreated(LocalDate.now());
        entity.setActive(true);
        repository.save(entity);
    }



    @Override
    public List<CourseContentGetRequestDto> getAllByCourseId(long courseId) throws Exception{
        Optional<Course> course = courseRepository.findById(courseId);
        if(!course.isPresent()){
            throw new Exception("course not found");
        }
        List<CourseContent> entities = repository.getAllByCourseId(courseId);

        List<CourseContentGetRequestDto> dtos = new ArrayList<CourseContentGetRequestDto>();
        if(entities != null && entities.size() > 0){
            for (CourseContent cc : entities) {
                dtos.add(mapper.mapToGetDto(cc));
            }
        }
        return dtos;
    }

    @Override
    public void delete(long id) throws Exception{
        Optional<CourseContent> entityContainer = repository.findById(id);
        if(!entityContainer.isPresent()){
            throw new Exception("content not found");
        }
        CourseContent content = entityContainer.get();
        content.setActive(false);
        repository.save(content);
    }
}
