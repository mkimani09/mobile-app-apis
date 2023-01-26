package com.faidihr.mobile.app.api.pojo;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDetails {

    private String username;

    private String email;

    private String fullName;

    private String employerClientCode;

    private Long tenantID;
}
