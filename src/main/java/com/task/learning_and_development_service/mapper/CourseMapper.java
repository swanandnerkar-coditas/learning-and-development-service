package com.task.learning_and_development_service.mapper;

import com.task.learning_and_development_service.dto.request.CourseRequestDTO;
import com.task.learning_and_development_service.model.Course;
import com.task.learning_and_development_service.model.Lecture;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public Course toEntity(CourseRequestDTO courseRequestDTO){
        return Course.builder()
                .name(courseRequestDTO.getName())
                .duration(courseRequestDTO.getDuration())
                .build();
    }

    public List<Lecture> toLectures(CourseRequestDTO courseRequestDTO, Course course){
         return courseRequestDTO.getLectures().stream()
                .map(link -> new Lecture(course, link))
                 .collect(Collectors.toList());
    }
}
