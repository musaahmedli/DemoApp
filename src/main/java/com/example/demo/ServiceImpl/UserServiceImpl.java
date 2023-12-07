package com.example.demo.ServiceImpl;

import com.example.demo.Core.CustomExceptions.CustomException;
import com.example.demo.Core.CustomExceptions.UserAlreadyExistException;
import com.example.demo.Core.Role;
import com.example.demo.DataTransferObject.Request.PostDto.User.LoginRequest;
import com.example.demo.DataTransferObject.Request.PostDto.User.UserPostRequestDto;
import com.example.demo.DataTransferObject.Response.GetDto.User.UserGetResponseDto;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository,
                           UserMapper mapper,
                           PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserGetResponseDto> getAllUsers() throws Exception{

        List<User> users = repository.findAllActiveUsers ();
        if(users.isEmpty () || users.size () == 0){
            throw new Exception ( "any user found" );
        }
        List<UserGetResponseDto> userDtos = new ArrayList<UserGetResponseDto>();

        if(users.size() > 0) {
            for (User user : users) {
                userDtos.add ( mapper.mapToGetDto ( user ) );
            }
        }
        return userDtos;
    }


    @Override
    public UserGetResponseDto getUserById(long id) throws Exception{

        User user  = repository.findActiveUserById ( id );
        if(user == null){
            throw new Exception ( "User not found" );
        }

        UserGetResponseDto userDto = mapper.mapToGetDto(user);

        return userDto;
    }

    @Override
    public void create( UserPostRequestDto userDto) throws Exception{
        Role admin = Role.ADMIN;
        Role normaluser = Role.NORMALUSER;
        Role instructor = Role.INSTRUCTOR;
        Role superuser = Role.SUPERUSER;

        if(userDto == null)
        {
            throw new Exception ( "user dto is null", new Throwable("in UserServiceImpl") );
        }

        if(!userDto.getRole().equals(admin.name()) &&
            !userDto.getRole().equals(normaluser.name()) &&
            !userDto.getRole().equals(instructor.name()) &&
            !userDto.getRole().equals(superuser.name()) )
        {
            throw new Exception ( "Role is not selected properly", new Throwable("in UserServiceImpl"));
        }
        if(userDto.getFirstName() == null)
        {
            throw new Exception ( "Firstname cannot be null", new Throwable("in UserServiceImpl"));
        }

        if(userDto.getLastName() == null)
        {
            throw new Exception ( "Lastname cannot be null", new Throwable("in UserServiceImpl") );
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = mapper.mapToEntity(userDto);
        user.setDateCreated(LocalDate.now());
        user.setActive(true);

        repository.save(user);

    }

    @Override
    public void delete(long id) throws Exception{

        User user = repository.findActiveUserById ( id );
        if(user == null){
            throw new Exception ( "no user found in database" );
        }

        user.setActive(false);
        user.setDateUpdated(LocalDate.now());

        repository.save(user);

    }

    @Override
    public UserGetResponseDto getLoginUser(LoginRequest loginRequest) throws Exception {
        if(loginRequest.getEmail() == null){
            throw new CustomException("email is null");
        }
        if(loginRequest.getPassword() == null){
            throw new CustomException("password is null");
        }

        User user = repository.findByEmail(loginRequest.getEmail());
        boolean matches = passwordEncoder.matches(loginRequest.getPassword(),user.getPassword());
        if(user != null && matches){
            return mapper.mapToGetDto(user);
        }
        return null;
    }

    @Override
    public boolean isUserExists(UserPostRequestDto user) throws Exception {
        if(user.getEmail() == null){
            throw new Exception("email is null");
        }
        User userFromDB = repository.findByEmail(user.getEmail());
        if(userFromDB != null){
            return true;
        }
        return false;
    }


}
