package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.Certificate.CertificatePostDto;
import com.example.demo.DataTransferObject.Response.GetDto.CertificateGetResponse;
import com.example.demo.Entity.Certificate;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CertificateMapper {
    Certificate mapToEntity(CertificatePostDto dto);
    CertificateGetResponse mapToGetDto(Certificate certificate);
}
