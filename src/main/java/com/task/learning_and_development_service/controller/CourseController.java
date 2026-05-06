package com.task.learning_and_development_service.controller;

import com.task.learning_and_development_service.dto.request.CourseRequestDTO;
import com.task.learning_and_development_service.dto.response.ApplicationResponse;
import com.task.learning_and_development_service.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/create-course")
    ResponseEntity<ApplicationResponse<String>> createCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO){
        ApplicationResponse<String> response = new ApplicationResponse<>(courseService.createCourse(courseRequestDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
