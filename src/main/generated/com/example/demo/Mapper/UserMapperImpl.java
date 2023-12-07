package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.User.UserPostRequestDto;
import com.example.demo.DataTransferObject.Response.GetDto.User.UserGetResponseDto;
import com.example.demo.Entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-07T15:15:22+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToEntity(UserPostRequestDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );
        user.setMetaUID( userDto.getMetaUID() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setPhoneNumber( userDto.getPhoneNumber() );
        user.setBiography( userDto.getBiography() );
        user.setRole( userDto.getRole() );

        return user;
    }

    @Override
    public UserGetResponseDto mapToGetDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserGetResponseDto userGetResponseDto = new UserGetResponseDto();

        userGetResponseDto.setId( user.getId() );
        userGetResponseDto.setFirstName( user.getFirstName() );
        userGetResponseDto.setLastName( user.getLastName() );
        userGetResponseDto.setRole( user.getRole() );
        userGetResponseDto.setPhoneNumber( user.getPhoneNumber() );
        userGetResponseDto.setBiography( user.getBiography() );
        userGetResponseDto.setEmail( user.getEmail() );

        return userGetResponseDto;
    }
}
