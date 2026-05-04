package com.task.learning_and_development_service.service;

import com.task.learning_and_development_service.dto.request.UserRequestDTO;
import com.task.learning_and_development_service.mapper.UserMapper;
import com.task.learning_and_development_service.model.User;
import com.task.learning_and_development_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public String registerUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.toEntity(userRequestDTO);
        try {
            userRepository.save(user);
        }
        catch (Exception ignored){
            // throw custom exception form here
            return "Failed to Register";
        }

        return "User Registered Successfully";
    }
}
