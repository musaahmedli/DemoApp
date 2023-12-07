package com.example.demo.Config;

import com.example.demo.Core.Constants;
import com.example.demo.DataTransferObject.Response.GetDto.User.UserGetResponseDto;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTConfiguration implements Serializable {
    public Claims resolveClaims(String authorization) {
        try {
            String token = splitBearerFromToken(authorization);
            if (token != null) {
                return extractAllClaims(token);
            }
            return null;
        } catch (Exception exception){
            throw exception;
        }
    }

    public String splitBearerFromToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
        return null;
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(Constants.SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public boolean checkExpireDateIsValid(Claims claims) {
        return claims.getExpiration().after(new Date());
    }

    public String generateToken(String email, UserGetResponseDto user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("firstname", user.getFirstName());
        claims.put("lastname", user.getLastName());
        claims.put("role", user.getRole());
        return createToken(claims, email);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Constants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, Constants.SECRET_KEY)
                .compact();
    }


}
