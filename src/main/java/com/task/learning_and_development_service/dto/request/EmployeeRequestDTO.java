package com.task.learning_and_development_service.dto.request;

import com.task.learning_and_development_service.enums.EmployeeStatus;
import com.task.learning_and_development_service.enums.EnrolledStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {

    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

//    @Enumerated(EnumType.STRING)
//    private EnrolledStatus enrolledStatus;

    @NotNull
    private Long userId;

}
