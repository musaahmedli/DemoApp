package com.example.demo.DataTransferObject.Response.GetDto.UserCertificate;

import com.example.demo.DataTransferObject.Response.GetDto.CertificateGetResponse;
import com.example.demo.DataTransferObject.Response.GetDto.User.UserGetResponseDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCertificateGetResponse {
    Long Id;
    CertificateGetResponse certificate;
    UserGetResponseDto user;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public CertificateGetResponse getCertificate() {
        return certificate;
    }

    public void setCertificate(CertificateGetResponse certificate) {
        this.certificate = certificate;
    }

    public UserGetResponseDto getUser() {
        return user;
    }

    public void setUser(UserGetResponseDto user) {
        this.user = user;
    }
}
