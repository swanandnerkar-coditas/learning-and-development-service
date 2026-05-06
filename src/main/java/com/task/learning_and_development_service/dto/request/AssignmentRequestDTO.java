package com.task.learning_and_development_service.dto.request;

import com.task.learning_and_development_service.model.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentRequestDTO {

    @NotNull
    private Long courseId;

    @NotBlank
    private String problemStatement;
}
