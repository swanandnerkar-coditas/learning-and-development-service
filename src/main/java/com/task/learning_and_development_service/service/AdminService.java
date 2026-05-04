package com.task.learning_and_development_service.service;


import com.task.learning_and_development_service.dto.request.UserRequestDTO;

public interface AdminService {
    String registerUser(UserRequestDTO userRequestDTO);
}
