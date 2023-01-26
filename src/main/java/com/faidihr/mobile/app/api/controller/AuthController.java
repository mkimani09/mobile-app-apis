package com.faidihr.mobile.app.api.controller;

import com.faidihr.mobile.app.api.pojo.AuthenticationRequest;
import com.faidihr.mobile.app.api.service.AuthService;
import com.faidihr.mobile.app.api.util.exceptions.ErrorsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @Autowired
    private Validator validator;

    @GetMapping(path = "/token")
    public ResponseEntity<Object> getAccessToken(HttpServletRequest request, @RequestBody AuthenticationRequest authenticationRequest, Errors errors) throws Exception {
        validator.validate(authenticationRequest, errors);
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorsUtil.getInstance().notifyErrors(errors));
        }

        return authService.getAccessToken(authenticationRequest);

    }
}
