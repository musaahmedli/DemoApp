package com.example.demo.Core;

import com.example.demo.Config.JWTConfiguration;
import com.example.demo.Core.CustomExceptions.InvalidAuthorizationException;
import com.example.demo.Core.CustomExceptions.UserNotAuthorizedException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;

public class Auth {
    private static JWTConfiguration jwt;
    @Autowired
    public Auth(JWTConfiguration jwt){
        this.jwt = jwt;
    }
    public static boolean authorizationIsValid(String authorization,boolean checkRole) throws Exception{
        if(authorization == null || authorization == ""){
            throw new InvalidAuthorizationException("authorization string is null");
        }

        Claims claims = jwt.resolveClaims(authorization);
        boolean isValid = jwt.checkExpireDateIsValid(claims);
        if(!isValid){
            throw new InvalidAuthorizationException("expire time exceeded");
        }
        String value = (String) claims.get("role");

        if(checkRole &&
                value != Role.ADMIN.name() &&
                value != Role.SUPERUSER.name() &&
                value != Role.INSTRUCTOR.name()){
            throw new UserNotAuthorizedException("user does not have permission to this process");
        }
        return true;
    }
}
