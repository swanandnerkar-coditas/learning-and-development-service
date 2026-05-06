package com.task.learning_and_development_service.service;

import com.task.learning_and_development_service.dto.request.EmployeeRequestDTO;
import jakarta.validation.Valid;

public interface EmployeeService {
    String registerEmployeeDetails(@Valid EmployeeRequestDTO employeeRequestDTO);
}
