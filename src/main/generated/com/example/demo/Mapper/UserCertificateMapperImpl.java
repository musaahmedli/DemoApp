package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.UserCertificate.UserCertificatePostDto;
import com.example.demo.DataTransferObject.Response.GetDto.UserCertificate.UserCertificateGetResponse;
import com.example.demo.Entity.UserCertificate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-07T15:15:22+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class UserCertificateMapperImpl implements UserCertificateMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CertificateMapper certificateMapper;

    @Override
    public List<UserCertificateGetResponse> mapToGetDto(List<UserCertificate> userCertificate) {
        if ( userCertificate == null ) {
            return null;
        }

        List<UserCertificateGetResponse> list = new ArrayList<UserCertificateGetResponse>( userCertificate.size() );
        for ( UserCertificate userCertificate1 : userCertificate ) {
            list.add( userCertificateToUserCertificateGetResponse( userCertificate1 ) );
        }

        return list;
    }

    @Override
    public UserCertificate mapToEntity(UserCertificatePostDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserCertificate userCertificate = new UserCertificate();

        return userCertificate;
    }

    protected UserCertificateGetResponse userCertificateToUserCertificateGetResponse(UserCertificate userCertificate) {
        if ( userCertificate == null ) {
            return null;
        }

        UserCertificateGetResponse userCertificateGetResponse = new UserCertificateGetResponse();

        userCertificateGetResponse.setId( userCertificate.getId() );
        userCertificateGetResponse.setCertificate( certificateMapper.mapToGetDto( userCertificate.getCertificate() ) );
        userCertificateGetResponse.setUser( userMapper.mapToGetDto( userCertificate.getUser() ) );

        return userCertificateGetResponse;
    }
}
