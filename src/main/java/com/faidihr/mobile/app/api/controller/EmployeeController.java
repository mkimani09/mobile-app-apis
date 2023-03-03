package com.faidihr.mobile.app.api.controller;

import com.faidihr.mobile.app.api.pojo.EmployeeRequest;
import com.faidihr.mobile.app.api.service.EmployeeService;
import com.faidihr.mobile.app.api.util.exceptions.ErrorsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private Validator validator;

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(path = "/employee")
    public ResponseEntity<Object> getEmployee(HttpServletRequest request, @RequestBody EmployeeRequest employeeRequest, Errors errors) throws Exception {
        validator.validate(employeeRequest, errors);
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorsUtil.getInstance().notifyErrors(errors));
        }

        return employeeService.getEmployee(employeeRequest);

    }
}