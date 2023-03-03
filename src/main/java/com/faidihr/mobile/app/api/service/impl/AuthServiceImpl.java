package com.faidihr.mobile.app.api.service.impl;


import com.faidihr.mobile.app.api.context.TenantContext;
import com.faidihr.mobile.app.api.model.User;
import com.faidihr.mobile.app.api.model.repository.UserRepository;
import com.faidihr.mobile.app.api.pojo.AuthenticationRequest;
import com.faidihr.mobile.app.api.pojo.GenericResponse;
import com.faidihr.mobile.app.api.service.AuthService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class AuthServiceImpl implements AuthService {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    private static final String JWT_SECRET = "Awesome12Key$";
    @Autowired
    UserRepository userRepository;

    @Autowired
    Environment environment;

    @Override
    public ResponseEntity<Object> getAccessToken(AuthenticationRequest authenticationRequest) {

        User user = userRepository.findUserByEmail(authenticationRequest.getEmail());

        if (Objects.isNull(user)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(GenericResponse.GenericResponseData.builder()
                            .status(HttpStatus.NOT_FOUND.value())
                            .message("User not found.")
                            .msgDeveloper("User not found - " + authenticationRequest.getEmail() + ". Current Tenant: " +TenantContext.getCurrentTenant())
                            //.data()
                            .build());
        }
/**
        if (!verifyPassword("Faidi@2022", "$2y$13$jZQ3exk98K8pWtoM74DH1.vNKhZWkwp1DLMoLqhPHJ7oYzhNotPyi")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(GenericResponse.GenericResponseData.builder()
                            .status(HttpStatus.UNAUTHORIZED.value())
                            .message("Invalid Password")
                            .msgDeveloper("Invalid Password for user - " + authenticationRequest.getEmail())
                            //.data()
                            .build());
        }
**/
        JSONObject resp = new JSONObject();
        resp.put("accessToken", generateToken(user));
        resp.put("phoneNumber", user.getPhoneNumber());
        resp.put("email", user.getEmail());

        return ResponseEntity.status(HttpStatus.OK)
                .body(GenericResponse.GenericResponseData.builder()
                        .status(HttpStatus.OK.value())
                        .message("Success")
                        .msgDeveloper("Success")
                        .data(resp.toMap())
                        .build());

    }

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("email", user.getEmail());
        claims.put("username", user.getUsername());
        claims.put("fullName", user.getFullnames());
        claims.put("tenantID", TenantContext.getCurrentTenant());
        return doGenerateToken(claims, user.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                //.setPayload(claims)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
    }
}
