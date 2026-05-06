package com.task.learning_and_development_service.controller;

import com.task.learning_and_development_service.dto.request.CourseRequestDTO;
import com.task.learning_and_development_service.dto.request.EmployeeRequestDTO;
import com.task.learning_and_development_service.dto.response.ApplicationResponse;
import com.task.learning_and_development_service.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create-course")
    ResponseEntity<ApplicationResponse<String>> registerEmployeeDetails(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO){
        ApplicationResponse<String> response = new ApplicationResponse<>(employeeService.registerEmployeeDetails(employeeRequestDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
