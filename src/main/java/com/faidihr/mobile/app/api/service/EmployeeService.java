package com.faidihr.mobile.app.api.service;

import com.faidihr.mobile.app.api.pojo.EmployeeRequest;
import org.springframework.http.ResponseEntity;


public interface EmployeeService {

    ResponseEntity<Object> getEmployee(EmployeeRequest EmployeeRequest);
}
