package com.task.learning_and_development_service.service;

import com.task.learning_and_development_service.dto.request.CourseRequestDTO;
import jakarta.validation.Valid;

public interface CourseService {

    String createCourse(@Valid CourseRequestDTO courseRequestDTO);

}
