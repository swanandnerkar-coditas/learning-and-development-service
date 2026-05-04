package com.task.learning_and_development_service.dto.request;

import com.task.learning_and_development_service.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank
    private String username;

    @NotNull
    private LocalDate password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Email
    @NotBlank
    private String email;
}
