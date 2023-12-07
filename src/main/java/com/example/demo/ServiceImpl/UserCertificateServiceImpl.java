package com.example.demo.ServiceImpl;

import com.example.demo.Core.FileType;
import com.example.demo.DataTransferObject.Request.PostDto.UserCertificate.UserCertificatePostDto;
import com.example.demo.DataTransferObject.Response.GetDto.UserCertificate.UserCertificateGetResponse;
import com.example.demo.Entity.Certificate;
import com.example.demo.Entity.User;
import com.example.demo.Entity.UserCertificate;
import com.example.demo.Mapper.UserCertificateMapper;
import com.example.demo.Repository.CertificateRepository;
import com.example.demo.Repository.UserCertificateRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.FileHandlingService;
import com.example.demo.Service.UserCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Path;
import java.util.List;

@Service
public class UserCertificateServiceImpl implements UserCertificateService {
    private final UserCertificateRepository userCertificateRepository;
    private final UserCertificateMapper userCertificateMapper;
    private final CertificateRepository certificateRepository;
    private final UserRepository userRepository;
    private final FileHandlingService fileHandlingService;

    @Autowired
    public UserCertificateServiceImpl(UserCertificateRepository userCertificateRepository,
                                      UserCertificateMapper userCertificateMapper,
                                      UserRepository userRepository,
                                      CertificateRepository certificateRepository,
                                      FileHandlingService fileHandlingService) {
        this.userCertificateRepository = userCertificateRepository;
        this.userCertificateMapper = userCertificateMapper;
        this.certificateRepository = certificateRepository;
        this.userRepository = userRepository;
        this.fileHandlingService = fileHandlingService;
    }

    @Override
    public List<UserCertificateGetResponse> getUserCertificates(Long userId) throws Exception{
        if(userId == 0){
            throw new Exception("user id is zero");
        }
        List<UserCertificate> certificates = userCertificateRepository.getUserCertificates(userId);
        if(certificates == null || certificates.size() == 0){
            throw new Exception("no certificate found belonged to user");
        }

        List<UserCertificateGetResponse> response = userCertificateMapper.mapToGetDto(certificates);
        return response;
    }

    @Override
    public void submitUserCertificate(UserCertificatePostDto dto) throws Exception{
        if(dto == null){
            throw new Exception("dto is null");
        }
        if(dto.getCourseId() == 0){
            throw new Exception("courseId is zero");
        }
        if(dto.getUserId() == 0){
            throw new Exception("userid is zero");
        }


        UserCertificate userCertificate = userCertificateMapper.mapToEntity(dto);

        Certificate certificate = certificateRepository.getCertificateByCourse(dto.getCourseId());

        if(certificate == null){
            throw new Exception("course certificate not found");
        }

        userCertificate.setCertificate(certificate);

        User user = userRepository.findActiveUserById(dto.getUserId());

        if(user == null){
            throw new Exception("user not found");
        }

        userCertificate.setUser(user);
        try {
            byte[] resp = fileHandlingService.getFileByFullPath(certificate.getFullPath());
            String filename = null;
            if(certificate.getFileName() ==null){
                String temp = certificate.getFullPath();
                String[] arr = temp.split("/");
                int index = 0;
                index = arr.length;
                filename  = arr[index-1];
            }

            Path path = fileHandlingService.saveFileToServer(resp, filename, user.getId(), FileType.UserCertificate.toString());
        }
        catch(Exception exception){
            throw new Exception(exception.getMessage());
        }

        userCertificateRepository.save(userCertificate);
    }
}
