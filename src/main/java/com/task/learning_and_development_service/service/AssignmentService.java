package com.task.learning_and_development_service.service;

import com.task.learning_and_development_service.dto.request.AssignmentRequestDTO;
import jakarta.validation.Valid;

public interface AssignmentService {
    String createAssignment(@Valid AssignmentRequestDTO assignmentRequestDTO);
}
