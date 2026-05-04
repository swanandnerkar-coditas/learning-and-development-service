package com.task.learning_and_development_service.controller;

import com.task.learning_and_development_service.dto.response.ApplicationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @PostMapping
    ResponseEntity<ApplicationResponse<>>
}
