package com.example.demo.DataTransferObject.Request.PostDto.CourseContentComment;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseContentCommentPostDto {

    String Comment;
    Long ContentId;
    Long UserId;

    public String getComment() {

        return Comment;
    }

    public void setComment(String comment) {

        Comment = comment;
    }

    public Long getContentId() {

        return ContentId;
    }

    public void setContentId(Long contentId) {

        ContentId = contentId;
    }

    public Long getUserId() {

        return UserId;
    }

    public void setUserId(Long userId) {

        UserId = userId;
    }

}
