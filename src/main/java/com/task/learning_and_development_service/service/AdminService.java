package com.task.learning_and_development_service.service;


import com.task.learning_and_development_service.dto.request.CourseRequestDTO;
import com.task.learning_and_development_service.dto.request.UserRequestDTO;
import com.task.learning_and_development_service.dto.response.AdminProfileDTO;
import jakarta.validation.Valid;

public interface AdminService {
    String registerUser(UserRequestDTO userRequestDTO);

    String createCourse(@Valid CourseRequestDTO courseRequestDTO);

    AdminProfileDTO profile();
}
