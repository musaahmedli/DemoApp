package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.UserCertificate.UserCertificatePostDto;
import com.example.demo.DataTransferObject.Response.GetDto.UserCertificate.UserCertificateGetResponse;
import com.example.demo.Entity.UserCertificate;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(uses = {UserMapper.class,CertificateMapper.class},componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserCertificateMapper {
    List<UserCertificateGetResponse> mapToGetDto(List<UserCertificate> userCertificate);
    UserCertificate mapToEntity(UserCertificatePostDto dto);

}
