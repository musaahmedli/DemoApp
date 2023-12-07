package com.example.demo.Service;

import com.example.demo.DataTransferObject.Request.PostDto.CourseContentComment.CourseContentCommentPostDto;

public interface CourseContentCommentService {
    void submitComment(CourseContentCommentPostDto dto) throws  Exception;
}
