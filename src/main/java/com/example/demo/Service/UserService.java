package com.example.demo.Service;

import com.example.demo.DataTransferObject.Request.PostDto.User.LoginRequest;
import com.example.demo.DataTransferObject.Request.PostDto.User.UserPostRequestDto;
import com.example.demo.DataTransferObject.Response.GetDto.User.UserGetResponseDto;

import java.util.List;

public interface UserService {
    List<UserGetResponseDto> getAllUsers() throws Exception;

    UserGetResponseDto getUserById(long id) throws Exception;

    void create(UserPostRequestDto userDto) throws Exception;

    void delete(long id) throws Exception;

    UserGetResponseDto getLoginUser(LoginRequest loginRequest) throws Exception;

    boolean isUserExists(UserPostRequestDto user) throws Exception;

    //void update(UserDto userDto);
}
