package com.task.learning_and_development_service.service;

import com.task.learning_and_development_service.dto.request.AssignmentRequestDTO;
import com.task.learning_and_development_service.dto.request.AssignmentSubmitRequestDTO;
import com.task.learning_and_development_service.enums.AssignmentStatus;
import jakarta.validation.Valid;

public interface AssignmentService {
    String createAssignment(@Valid AssignmentRequestDTO assignmentRequestDTO);

    String submitAssignment(@Valid AssignmentSubmitRequestDTO assignmentSubmitRequestDTO);

    String checkAssignment(Long assignmentSubmissionId, AssignmentStatus resultStatus);
}
