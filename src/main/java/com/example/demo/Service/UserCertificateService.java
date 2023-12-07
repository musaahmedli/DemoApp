package com.example.demo.Service;

import com.example.demo.DataTransferObject.Request.PostDto.UserCertificate.UserCertificatePostDto;
import com.example.demo.DataTransferObject.Response.GetDto.UserCertificate.UserCertificateGetResponse;

import java.util.List;

public interface UserCertificateService {
    List<UserCertificateGetResponse> getUserCertificates(Long userId) throws Exception;
    void submitUserCertificate(UserCertificatePostDto dto) throws Exception;
}
