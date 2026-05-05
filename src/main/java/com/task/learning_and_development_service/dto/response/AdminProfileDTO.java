package com.task.learning_and_development_service.dto.response;

import com.task.learning_and_development_service.enums.Role;
import org.springframework.stereotype.Component;

@Component
public class AdminProfileDTO {

    private String username;

    private String name;

    private String email;

    private Role role;
}
