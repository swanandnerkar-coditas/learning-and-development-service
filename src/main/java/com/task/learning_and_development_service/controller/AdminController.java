package com.task.learning_and_development_service.controller;

import com.task.learning_and_development_service.dto.request.CourseRequestDTO;
import com.task.learning_and_development_service.dto.request.UserRequestDTO;
import com.task.learning_and_development_service.dto.response.ApplicationResponse;
import com.task.learning_and_development_service.service.AdminService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/register-user")
    ResponseEntity<ApplicationResponse<String>> registerUser(@Valid @RequestBody UserRequestDTO userRequestDTO){

        ApplicationResponse<String> response = new ApplicationResponse<>(adminService.registerUser(userRequestDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/create-course")
    ResponseEntity<ApplicationResponse<String>> createCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO){

        ApplicationResponse<String> response = new ApplicationResponse<>(adminService.createCourse(courseRequestDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
