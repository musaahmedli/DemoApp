package com.example.demo.Controller;

import com.example.demo.Config.JWTConfiguration;
import com.example.demo.Core.Auth;
import com.example.demo.Core.CustomExceptions.InvalidAuthorizationException;
import com.example.demo.Core.CustomExceptions.UserNotAuthorizedException;
import com.example.demo.Core.CustomResponse.ResponseHandler;
import com.example.demo.Core.Role;
import com.example.demo.DataTransferObject.Request.PostDto.Certificate.CertificatePostDto;
import com.example.demo.DataTransferObject.Response.GetDto.CertificateGetResponse;
import com.example.demo.Service.CertificateService;
import io.jsonwebtoken.Claims;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/Certificate")
public class CertificateController {
    private final CertificateService certificateService;
    private final JWTConfiguration jwt;

    @Autowired
    public CertificateController(CertificateService certificateService,
                                 JWTConfiguration jwt) {
        this.certificateService = certificateService;
        this.jwt = jwt;
    }

    @PostMapping(value = "/saveByCourse/{courseId}")
    public ResponseEntity<Object> saveCourseCertificate(String authorization, @PathVariable Long courseId, MultipartFile certificate){
        try{
            Auth.authorizationIsValid(authorization,true);

            CertificatePostDto certificatePostDto = new CertificatePostDto();
            certificatePostDto.setCourseId(courseId);
            certificatePostDto.setCertificate(certificate);
            certificateService.postCertificateForCourse(certificatePostDto);
            return ResponseHandler.generateResponse("success",HttpStatus.OK,"Created successfully");
        }
        catch (NoSuchElementException exception){
            return ResponseHandler.generateResponse(exception.getMessage(),HttpStatus.NOT_FOUND,null);
        }
        catch (Exception exception){
            return ResponseHandler.generateResponse(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/getByCourse/{courseId}")
    public ResponseEntity<Object> getCourseCertificate(@PathVariable Long courseId){
        try{
            CertificateGetResponse certificate = certificateService.getCertificateByCourse(courseId);
            return ResponseHandler.generateResponse("found in database",HttpStatus.OK,certificate);
        }
        catch (NoSuchElementException exception){
            return ResponseHandler.generateResponse(exception.getMessage(),HttpStatus.NOT_FOUND,null);
        }
        catch (Exception exception){
            return ResponseHandler.generateResponse(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

}
