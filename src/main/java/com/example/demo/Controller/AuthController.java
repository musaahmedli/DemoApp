package com.example.demo.Controller;

import com.example.demo.Config.JWTConfiguration;
import com.example.demo.Core.CustomResponse.ResponseHandler;
import com.example.demo.DataTransferObject.Request.PostDto.User.LoginRequest;
import com.example.demo.DataTransferObject.Request.PostDto.User.UserPostRequestDto;
import com.example.demo.DataTransferObject.Response.GetDto.User.UserGetResponseDto;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/v1/Auth")
public class AuthController {
    private final JWTConfiguration jwt;
    private final UserService userService;
    @Autowired
    public AuthController(JWTConfiguration jwt,
                          UserService userService) {
        this.jwt = jwt;
        this.userService = userService;
    }

    @PostMapping("/oauth2/login")
    public ResponseEntity<Object> loginWithSocial(){
        return ResponseHandler.generateResponse("success",HttpStatus.OK,null);
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
        UserGetResponseDto resp = null;
        try {
            resp = userService.getLoginUser(request);
        }
        catch (Exception ex){
            return ResponseHandler.generateResponse("error",HttpStatus.INTERNAL_SERVER_ERROR,"error in login process");
        }
        if(resp != null){
            String token = jwt.generateToken(request.getEmail(),resp);
            return ResponseHandler.generateResponse("logged in", HttpStatus.OK, token);

        }
        return ResponseHandler.generateResponse("resp is null", HttpStatus.INTERNAL_SERVER_ERROR, null);

    }

    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@RequestBody UserPostRequestDto userDto){
        try
        {
            if(userService.isUserExists(userDto)){
                return ResponseHandler.generateResponse("user connected to this email already exists",HttpStatus.FOUND,null);
            }
            userService.create(userDto);
            return ResponseHandler.generateResponse("user created successfully",HttpStatus.OK,null);
        }
        catch ( Exception exception )
        {
            return ResponseHandler.generateResponse(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }
}
