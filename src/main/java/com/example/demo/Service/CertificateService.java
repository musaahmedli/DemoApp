package com.example.demo.Service;

import com.example.demo.DataTransferObject.Request.PostDto.Certificate.CertificatePostDto;
import com.example.demo.DataTransferObject.Response.GetDto.CertificateGetResponse;

public interface CertificateService {
    CertificateGetResponse getCertificateByCourse(Long CourseId) throws Exception;
    void postCertificateForCourse(CertificatePostDto dto) throws Exception;
}
