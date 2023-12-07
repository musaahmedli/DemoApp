package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.User.UserPostRequestDto;
import com.example.demo.DataTransferObject.Response.GetDto.User.UserGetResponseDto;
import com.example.demo.Entity.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User mapToEntity(UserPostRequestDto userDto);
    UserGetResponseDto mapToGetDto(User user);
}
