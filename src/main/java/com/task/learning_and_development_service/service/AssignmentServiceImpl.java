package com.task.learning_and_development_service.service;

import com.task.learning_and_development_service.dto.request.AssignmentRequestDTO;
import com.task.learning_and_development_service.dto.request.AssignmentSubmitRequestDTO;
import com.task.learning_and_development_service.enums.AssignmentStatus;
import com.task.learning_and_development_service.model.Assignment;
import com.task.learning_and_development_service.model.AssignmentSubmission;
import com.task.learning_and_development_service.model.Course;
import com.task.learning_and_development_service.model.EmployeeDetails;
import com.task.learning_and_development_service.repository.AssignmentRepository;
import com.task.learning_and_development_service.repository.AssignmentSubmissionRepository;
import com.task.learning_and_development_service.repository.CourseRepository;
import com.task.learning_and_development_service.repository.EmployeeDetailsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService{

    private final CourseRepository courseRepository;
    private final AssignmentRepository assignmentRepository;
    private final EmployeeDetailsRepository employeeDetailsRepository;
    private final AssignmentSubmissionRepository assignmentSubmissionRepository;

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

    @Override
    public String submitAssignment(AssignmentSubmitRequestDTO assignmentSubmitRequestDTO) {

        EmployeeDetails employeeDetails = employeeDetailsRepository.findById(assignmentSubmitRequestDTO.getEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException("Employee not found for provided id"));

        Assignment assignment = assignmentRepository.findById(assignmentSubmitRequestDTO.getAssignmentId())
                .orElseThrow(() -> new EntityNotFoundException("Assignment not found for provided id"));

//        if(assignment.getCourse() != )
        AssignmentSubmission assignmentSubmission = AssignmentSubmission.builder()
                .assignment(assignment)
                .assignmentStatus(AssignmentStatus.SUBMITTED)
                .employeeDetails(employeeDetails)
                .gitHubLink(assignmentSubmitRequestDTO.getGitHubLink())
                .build();

        try{
            assignmentSubmissionRepository.save(assignmentSubmission);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "";
    }

    @Override
    public String checkAssignment(Long assignmentSubmissionId, AssignmentStatus resultStatus) {

        AssignmentSubmission assignmentSubmission = assignmentSubmissionRepository.findById(assignmentSubmissionId)
                .orElseThrow(() -> new EntityNotFoundException("Assignment request not found for provided Id"));

        assignmentSubmission.setAssignmentStatus(resultStatus);
        try{
            assignmentSubmissionRepository.save(assignmentSubmission);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Assignment Status Updated Successfully";
    }
}
