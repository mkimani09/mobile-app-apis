package com.faidihr.mobile.app.api.pojo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class EmployeeRequest {

    @NotNull
    private String email;

    private String id_no;

    public EmployeeRequest(@NotNull String email, String id_no) {

    }


}
