package com.task.learning_and_development_service.service;

import com.task.learning_and_development_service.dto.request.AssignmentRequestDTO;
import com.task.learning_and_development_service.model.Assignment;
import com.task.learning_and_development_service.model.Course;
import com.task.learning_and_development_service.repository.AssignmentRepository;
import com.task.learning_and_development_service.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService{

    private final CourseRepository courseRepository;
    private final AssignmentRepository assignmentRepository;

    @Override
    public String createAssignment(AssignmentRequestDTO assignmentRequestDTO) {

        Course course = courseRepository.findById(assignmentRequestDTO.getCourseId())
                .orElseThrow(() -> new EntityNotFoundException("Course not found for provided Id"));

        Assignment assignment = new Assignment();
        assignment.setCourse(course);
        assignment.setProblemStatement(assignmentRequestDTO.getProblemStatement());

        try{
            assignmentRepository.save(assignment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Assignment added Successfully";
    }
}
