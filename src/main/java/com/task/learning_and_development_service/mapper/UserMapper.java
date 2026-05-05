package com.task.learning_and_development_service.mapper;

import com.task.learning_and_development_service.dto.request.UserRequestDTO;
import com.task.learning_and_development_service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final BCryptPasswordEncoder encoder;

    public User toEntity(UserRequestDTO userRequestDTO){
        return User.builder()
                .username(userRequestDTO.getUsername())
                .password(encoder.encode(String.valueOf(userRequestDTO.getPassword())))
                .name(userRequestDTO.getUsername())
                .role(userRequestDTO.getRole())
                .email(userRequestDTO.getEmail())
                .build();
    }


}
