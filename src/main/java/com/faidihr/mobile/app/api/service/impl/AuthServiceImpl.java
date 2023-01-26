package com.faidihr.mobile.app.api.service.impl;


import com.faidihr.mobile.app.api.context.TenantContext;
import com.faidihr.mobile.app.api.model.Client;
import com.faidihr.mobile.app.api.model.User;
import com.faidihr.mobile.app.api.model.repository.ClientRepository;
import com.faidihr.mobile.app.api.model.repository.UserRepository;
import com.faidihr.mobile.app.api.pojo.AuthenticationRequest;
import com.faidihr.mobile.app.api.pojo.GenericResponse;
import com.faidihr.mobile.app.api.service.AuthService;
import com.faidihr.mobile.app.api.util.enums.UserStatus;
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

    private static  final String JWT_SECRET = "Awesome12Key$";
    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientRepository clientsRepository;

    @Autowired
   Environment environment;

    @Override
    public ResponseEntity<Object> getAccessToken(AuthenticationRequest authenticationRequest) {

        Client client = clientsRepository.findClientsByAdminEmailAndActiveStatus(authenticationRequest.getEmail(),UserStatus.ACTIVE.getStatus());

        if (Objects.isNull(client)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(GenericResponse.GenericResponseData.builder()
                            .status(HttpStatus.NOT_FOUND.value())
                            .message("User not found")
                            .msgDeveloper("User not found" + authenticationRequest.getEmail())
                            //.data()
                            .build());
        }

        User user = userRepository.findUserByEmailAndStatus(authenticationRequest.getEmail(), UserStatus.ACTIVE.getStatus());

        if (Objects.isNull(user)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(GenericResponse.GenericResponseData.builder()
                            .status(HttpStatus.NOT_FOUND.value())
                            .message("User not found")
                            .msgDeveloper("User not found" + authenticationRequest.getEmail())
                            //.data()
                            .build());
        }

        JSONObject resp = new  JSONObject();
        resp.put("accessToken",generateToken(user));

        return ResponseEntity.status(HttpStatus.OK)
                .body(GenericResponse.GenericResponseData.builder()
                        .status(HttpStatus.OK.value())
                        .message("Login Success")
                        .msgDeveloper("Login Success")
                        .data(resp)
                        .build());

    }

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("email", user.getEmail());
        claims.put("username", user.getUsername());
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
