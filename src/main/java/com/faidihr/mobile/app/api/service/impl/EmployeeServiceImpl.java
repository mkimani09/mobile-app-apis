package com.faidihr.mobile.app.api.service.impl;

import com.faidihr.mobile.app.api.model.Employee;

import com.faidihr.mobile.app.api.model.repository.EmployeeRepository;
import com.faidihr.mobile.app.api.pojo.EmployeeRequest;
import com.faidihr.mobile.app.api.pojo.GenericResponse;
import com.faidihr.mobile.app.api.service.EmployeeService;

import com.faidihr.mobile.app.api.util.enums.EmployeeTerminationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<Object> getEmployee(EmployeeRequest employeeRequest) {
        Employee newEmployee = employeeRepository.findEmployeeByEmailAndEmpTerminated(employeeRequest.getEmail(), EmployeeTerminationStatus.ACTIVE.getStatus());
        if (Objects.isNull(newEmployee)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(GenericResponse.GenericResponseData.builder()
                            .status(HttpStatus.NOT_FOUND.value())
                            .message("Employee not Found")
                            .data("NotFound")
                            .msgDeveloper("Employee not Found " + employeeRequest.getEmail())
                            .build());
        }
        return ResponseEntity.ok(newEmployee);
    }
}
