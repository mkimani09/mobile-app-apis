package com.faidihr.mobile.app.api.service;

import com.faidihr.mobile.app.api.pojo.AuthenticationRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<Object> getAccessToken(AuthenticationRequest authenticationRequest);
}
