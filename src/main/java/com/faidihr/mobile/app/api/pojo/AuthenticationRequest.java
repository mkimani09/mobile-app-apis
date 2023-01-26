package com.faidihr.mobile.app.api.pojo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class AuthenticationRequest {

    @NotNull
    private String email;

    @NotNull
    private String password;


    private String accessToken;

    public AuthenticationRequest(@NotNull String email, @NotNull String password) {
        this.email = email;
        this.password = password;
    }
}
