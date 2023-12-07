package com.example.demo.Controller;

import com.example.demo.Core.CustomResponse.ResponseHandler;
import com.example.demo.DataTransferObject.Request.PostDto.UserCertificate.UserCertificatePostDto;
import com.example.demo.Service.UserCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/UserCertificates")
public class UserCertificateController {
    private final UserCertificateService userCertificateService;

    @Autowired
    public UserCertificateController(UserCertificateService userCertificateService) {
        this.userCertificateService = userCertificateService;
    }

    @PostMapping("/saveUserCertificate")
    public ResponseEntity<Object> submitUserCertificate(UserCertificatePostDto request){
        try {
            userCertificateService.submitUserCertificate(request);
            return ResponseHandler.generateResponse("success",HttpStatus.OK,null);
        }
        catch(Exception exception){
            return ResponseHandler.generateResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }
}
