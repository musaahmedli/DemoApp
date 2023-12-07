package com.example.demo.ServiceImpl;

import com.example.demo.Core.CustomExceptions.NotFoundException;
import com.example.demo.DataTransferObject.Request.PostDto.CourseContentComment.CourseContentCommentPostDto;
import com.example.demo.Entity.CourseContent;
import com.example.demo.Entity.CourseContentComment;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.CourseContentCommentMapper;
import com.example.demo.Repository.CourseContentCommentRepository;
import com.example.demo.Repository.CourseContentRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.CourseContentCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class CourseContentCommentServiceImpl implements CourseContentCommentService {

    private final CourseContentCommentRepository courseContentCommentRepository;
    private final CourseContentCommentMapper courseContentCommentMapper;
    private final UserRepository userRepository;
    private final CourseContentRepository courseContentRepository;

    @Autowired
    public CourseContentCommentServiceImpl(CourseContentCommentRepository courseContentCommentRepository,
                                           CourseContentCommentMapper courseContentCommentMapper,
                                           UserRepository userRepository,
                                           CourseContentRepository courseContentRepository){
        this.courseContentCommentRepository = courseContentCommentRepository;
        this.courseContentCommentMapper = courseContentCommentMapper;
        this.userRepository = userRepository;
        this.courseContentRepository = courseContentRepository;
    }
    @Override
    public void submitComment(CourseContentCommentPostDto dto) throws Exception{
        if(dto == null){
            throw new NullPointerException("comment dto is null");
        }

        if(dto.getComment() == null){
            return;
        }
        if(dto.getContentId() == 0){
            throw new Exception("contentId is null");
        }
        if(dto.getUserId() == 0){
            throw new Exception("userId is null");
        }

        CourseContentComment comment = courseContentCommentMapper.mapToEntity(dto);

        Optional<User> user =  userRepository.findById(dto.getUserId());

        if(!user.isPresent()){
            throw new NotFoundException("user not found");
        }

        comment.setCommentedUser(user.get());

        Optional<CourseContent> content = courseContentRepository.findById(dto.getContentId());

        if(!content.isPresent()){
            throw new NotFoundException("content not found");

        }
        comment.setCommentedCourseContent(content.get());
        comment.setActive(true);
        comment.setDateCommented(LocalDate.now());

        courseContentCommentRepository.save(comment);
    }

}
