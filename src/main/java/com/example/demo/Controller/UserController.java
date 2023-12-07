package com.example.demo.Controller;

import com.example.demo.Core.Role;
import com.example.demo.DataTransferObject.Request.PostDto.User.UserPostRequestDto;
import com.example.demo.DataTransferObject.Response.GetDto.User.UserGetResponseDto;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/Users")
public class UserController {

    private final UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserGetResponseDto>> getAllUsers(){

        try
        {
            List<UserGetResponseDto> users = service.getAllUsers();
            return new ResponseEntity<List<UserGetResponseDto>>(users, HttpStatus.OK);
        }
        catch ( Exception exception )
        {
            return new ResponseEntity<List<UserGetResponseDto>> (new ArrayList<UserGetResponseDto> ( ) ,HttpStatus.NOT_FOUND );
        }
    }



    @GetMapping("/Id/{id}")
    public ResponseEntity<UserGetResponseDto> getUserById(@RequestParam long id){

        try
        {
            UserGetResponseDto userDto = service.getUserById(id);
            return new ResponseEntity<UserGetResponseDto>(userDto,HttpStatus.OK);
        }
        catch ( Exception exception )
        {
            return new ResponseEntity<UserGetResponseDto>(new UserGetResponseDto (  ),HttpStatus.NOT_FOUND);
        }
    }

//    @PatchMapping("updateUserEmail")
//    public ResponseEntity<String> updateUserEmail( @RequestBody long id,@Email String email){
//
//        UserGetResponseDto userDtoFromDb = service.getUserById(id);
//
//        if(userDtoFromDb == null){
//            return new ResponseEntity<String>("User not found in database",HttpStatus.NOT_FOUND);
//        }
//
//        userDtoFromDb.setEmail(email);
//
//
//        service.update(userDtoFromDb);
//        return new ResponseEntity<String>("User updated successfully",HttpStatus.OK);
//    }

//    @PatchMapping("updateUserPassword")
//    public ResponseEntity<String> updateUserPassword(@Valid @RequestBody long id,String password){
//
//        UserDto userDtoFromDb = service.getUserById(id);
//
//        if(userDtoFromDb == null){
//            return new ResponseEntity<String>("User not found in database",HttpStatus.NOT_FOUND);
//        }
//
//        userDtoFromDb.setPassword(password);
//
//        service.UpdateUser(userDtoFromDb);
//        return new ResponseEntity<String>("User updated successfully",HttpStatus.OK);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@RequestParam Long id){
        try
        {
            service.getUserById(id);
            service.delete(id);
            return new ResponseEntity<String>("User deleted successfully",HttpStatus.OK);
        }
        catch ( Exception exception )
        {
            return new ResponseEntity<String>(exception.getMessage (),HttpStatus.NOT_FOUND);
        }
    }

}
