package com.task.learning_and_development_service.service;

import com.task.learning_and_development_service.dto.request.CourseRequestDTO;
import com.task.learning_and_development_service.dto.request.UserRequestDTO;
import com.task.learning_and_development_service.dto.response.AdminProfileDTO;
import com.task.learning_and_development_service.mapper.CourseMapper;
import com.task.learning_and_development_service.mapper.UserMapper;
import com.task.learning_and_development_service.model.Course;
import com.task.learning_and_development_service.model.Lecture;
import com.task.learning_and_development_service.model.User;
import com.task.learning_and_development_service.repository.CourseRepository;
import com.task.learning_and_development_service.repository.LectureRepository;
import com.task.learning_and_development_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    @Override
    public AdminProfileDTO profile() {
        return null;
    }
}
