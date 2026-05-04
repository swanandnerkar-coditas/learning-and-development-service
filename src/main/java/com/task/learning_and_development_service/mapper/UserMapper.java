package com.task.learning_and_development_service.mapper;

import com.task.learning_and_development_service.dto.request.UserRequestDTO;
import com.task.learning_and_development_service.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO userRequestDTO){
        return User.builder()
                .username(userRequestDTO.getUsername())
                .password(String.valueOf(userRequestDTO.getPassword()))
                .role(userRequestDTO.getRole())
                .email(userRequestDTO.getEmail())
                .build();
    }


}
