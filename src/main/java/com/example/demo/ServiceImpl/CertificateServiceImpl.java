package com.example.demo.ServiceImpl;

import com.example.demo.Core.FileType;
import com.example.demo.DataTransferObject.Request.PostDto.Certificate.CertificatePostDto;
import com.example.demo.DataTransferObject.Response.GetDto.CertificateGetResponse;
import com.example.demo.Entity.Certificate;
import com.example.demo.Entity.Course;
import com.example.demo.Mapper.CertificateMapper;
import com.example.demo.Repository.CertificateRepository;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Service.CertificateService;
import com.example.demo.Service.FileHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;
    private final CertificateMapper certificateMapper;
    private final FileHandlingService fileHandlingService;
    private final CourseRepository courseRepository;

    @Autowired
    public CertificateServiceImpl(CertificateRepository certificateRepository,
                                  FileHandlingService fileHandlingService,
                                  CourseRepository courseRepository,
                                  CertificateMapper certificateMapper) {
        this.certificateRepository = certificateRepository;
        this.fileHandlingService = fileHandlingService;
        this.courseRepository = courseRepository;
        this.certificateMapper = certificateMapper;
    }

    @Override
    public CertificateGetResponse getCertificateByCourse(Long CourseId) throws Exception {

        Optional<Course> course = courseRepository.findById(CourseId);

        if (!course.isPresent()) {
            throw new NoSuchElementException("Course not found");
        }

        Certificate certificate = certificateRepository.getCertificateByCourse(CourseId);

        if (certificate == null) {
            throw new Exception("course certificate not found");
        }

        CertificateGetResponse response = certificateMapper.mapToGetDto(certificate);

        return response;
    }

    @Override
    public void postCertificateForCourse(CertificatePostDto dto) throws Exception {
        if (dto == null) {
            throw new Exception("certificate post dto is null");
        }

        if (dto.getCourseId() == null || dto.getCourseId() == 0) {
            throw new Exception("course id in certificate dto is null");
        }

        if (dto.getCertificate() == null) {
            throw new Exception("certificate file is null");
        }

        Optional<Course> course = courseRepository.findById(dto.getCourseId());

        if (!course.isPresent()) {
            throw new NoSuchElementException("course not found");
        }

        Path path = fileHandlingService.saveFileToServer(dto.getCertificate().getBytes(),
                                                            dto.getCertificate().getOriginalFilename(),
                                                            dto.getCourseId(),
                                                            FileType.Certificate.toString());

        Certificate certificate = certificateMapper.mapToEntity(dto);

        if (path != null) {
            certificate.setFullPath(path.toAbsolutePath().toString());
        }

        certificate.setCourse(course.get());

        certificate.setActive(true);

        certificateRepository.save(certificate);

    }
}
