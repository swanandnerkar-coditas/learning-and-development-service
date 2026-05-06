package com.task.learning_and_development_service.controller;

import com.task.learning_and_development_service.dto.request.EnrollCourseRequestDTO;
import com.task.learning_and_development_service.dto.response.ApplicationResponse;
import com.task.learning_and_development_service.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    ResponseEntity<ApplicationResponse<String>> enrollCourse(@Valid @RequestBody EnrollCourseRequestDTO enrollCourseRequestDTO){
        ApplicationResponse<String> response = new ApplicationResponse<>(enrollmentService.enrollCourse(enrollCourseRequestDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
