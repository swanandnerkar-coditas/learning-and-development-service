package com.task.learning_and_development_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentSubmitRequestDTO {

    @NotBlank
    private String gitHubLink;

    @NotNull
    private Long employeeId;

    @NotNull
    private Long assignmentId;
}
