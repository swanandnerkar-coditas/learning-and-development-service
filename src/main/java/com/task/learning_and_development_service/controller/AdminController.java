package com.task.learning_and_development_service.controller;

import com.task.learning_and_development_service.dto.request.CourseRequestDTO;
import com.task.learning_and_development_service.dto.request.UserRequestDTO;
import com.task.learning_and_development_service.dto.response.AdminProfileDTO;
import com.task.learning_and_development_service.dto.response.ApplicationResponse;
import com.task.learning_and_development_service.service.AdminService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    /*
        Implement Security first then we'll move to other functionalities as a lot of changes occur when working SecurityContext
     */
    @GetMapping("/profile")
    ResponseEntity<ApplicationResponse<AdminProfileDTO>> profile() {
        ApplicationResponse<AdminProfileDTO> response = new ApplicationResponse<>(adminService.profile());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
