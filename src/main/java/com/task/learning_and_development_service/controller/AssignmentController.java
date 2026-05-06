package com.task.learning_and_development_service.controller;

import com.task.learning_and_development_service.dto.request.AssignmentRequestDTO;
import com.task.learning_and_development_service.dto.request.CourseRequestDTO;
import com.task.learning_and_development_service.dto.response.ApplicationResponse;
import com.task.learning_and_development_service.service.AssignmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/assignment")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    // only ADMIN
    /*

     */
    @PostMapping
    ResponseEntity<ApplicationResponse<String>> createAssignment(@Valid @RequestBody AssignmentRequestDTO assignmentRequestDTO){
        ApplicationResponse<String> response = new ApplicationResponse<>(assignmentService.createAssignment(assignmentRequestDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
