package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.Certificate.CertificatePostDto;
import com.example.demo.DataTransferObject.Response.GetDto.CertificateGetResponse;
import com.example.demo.Entity.Certificate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-07T15:15:22+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class CertificateMapperImpl implements CertificateMapper {

    @Override
    public Certificate mapToEntity(CertificatePostDto dto) {
        if ( dto == null ) {
            return null;
        }

        Certificate certificate = new Certificate();

        return certificate;
    }

    @Override
    public CertificateGetResponse mapToGetDto(Certificate certificate) {
        if ( certificate == null ) {
            return null;
        }

        CertificateGetResponse certificateGetResponse = new CertificateGetResponse();

        certificateGetResponse.setId( certificate.getId() );
        certificateGetResponse.setFullPath( certificate.getFullPath() );
        certificateGetResponse.setFileName( certificate.getFileName() );
        certificateGetResponse.setFileType( certificate.getFileType() );

        return certificateGetResponse;
    }
}
