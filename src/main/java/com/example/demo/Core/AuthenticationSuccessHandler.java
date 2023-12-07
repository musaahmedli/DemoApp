package com.example.demo.Core;

import com.example.demo.Config.JWTConfiguration;
import com.example.demo.DataTransferObject.Oauth.CustomOauthUser;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final UserRepository userRepository;
    private final JWTConfiguration jwt;
    private final UserMapper userMapper;

    @Autowired
    public AuthenticationSuccessHandler(UserRepository userRepository,
                                        JWTConfiguration jwt,
                                        UserMapper userMapper){
        this.userRepository = userRepository;
        this.jwt = jwt;
        this.userMapper = userMapper;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        CustomOauthUser authUser = new CustomOauthUser();
        authUser.setAuthUser((OAuth2User)authentication.getPrincipal());
        System.out.println(authUser.authUser);
        if(authUser.authUser == null){
            return;
        }

        Map<String,Object> attributes =  authUser.getAttributes();

        String oauthType = identifyOauthType(request);


        if(attributes != null){
            String emailString = (String)attributes.get("email");
            User user = userRepository.findByEmail(emailString);
            if(user != null){
                String token = jwt.generateToken(emailString,userMapper.mapToGetDto(user));
                response.setHeader("Authorization",token);
                System.out.println(response.getHeader("Authorization"));
            }
            else{
                user = new User();
                user.setEmail(emailString);
                user.setActive(true);
                user.setAuthProvider(AuthProvider.Google);
                user.setDateCreated(LocalDate.now());
                user.setMetaUID(authUser.getName());
                user.setRole("User");
                user.setFirstName(attributes.getOrDefault("given_name",attributes.getOrDefault("name","null").toString()).toString());
                user.setLastName(attributes.getOrDefault("family_name",null).toString());

                userRepository.save(user);

                String token = jwt.generateToken(emailString,userMapper.mapToGetDto(user));
                response.setHeader("Authorization",token);
                System.out.println(response.getHeader("Authorization"));

            }
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }

    private void setUserDetails(User user,String oauthType){

    }
    private static String identifyOauthType(HttpServletRequest request){
        if(request.getRequestURL() != null && request.getRequestURL().toString().contains("facebook")){
            return "facebook";
        }
        if(request.getRequestURL() != null && request.getRequestURL().toString().contains("google")){
            return "google";
        }
        return null;
    }
}
