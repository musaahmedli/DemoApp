package com.example.demo.DataTransferObject.Oauth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class CustomOauthUser implements OAuth2User {

    public OAuth2User authUser ;
    @Override
    public Map<String, Object> getAttributes() {
        return authUser.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authUser.getAuthorities();
    }

    @Override
    public String getName() {
        return authUser.getName();
    }

    public OAuth2User getAuthUser() {
        return authUser;
    }

    public void setAuthUser(OAuth2User authUser) {
        this.authUser = authUser;
    }
}
