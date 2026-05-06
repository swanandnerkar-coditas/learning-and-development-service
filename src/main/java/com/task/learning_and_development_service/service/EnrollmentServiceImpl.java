package com.task.learning_and_development_service.service;

import com.task.learning_and_development_service.dto.request.EnrollCourseRequestDTO;
import com.task.learning_and_development_service.enums.CourseStatus;
import com.task.learning_and_development_service.enums.EnrolledStatus;
import com.task.learning_and_development_service.model.Course;
import com.task.learning_and_development_service.model.EmployeeDetails;
import com.task.learning_and_development_service.model.Enrollment;
import com.task.learning_and_development_service.model.User;
import com.task.learning_and_development_service.repository.CourseRepository;
import com.task.learning_and_development_service.repository.EmployeeDetailsRepository;
import com.task.learning_and_development_service.repository.EnrollmentRepository;
import com.task.learning_and_development_service.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService{

    private final EnrollmentRepository enrollmentRepository;
    private final EmployeeDetailsRepository employeeDetailsRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Override
    public String enrollCourse(EnrollCourseRequestDTO enrollCourseRequestDTO) {

        try {
            EmployeeDetails employeeDetails = employeeDetailsRepository.findById(enrollCourseRequestDTO.getEmployeeId())
                    .orElseThrow(() -> new EntityNotFoundException("user not found"));

            Course course = courseRepository.findById(enrollCourseRequestDTO.getCourseId())
                    .orElseThrow(() -> new EntityNotFoundException("course not found "));


            Enrollment enrollment = Enrollment.builder()
                    .course(course).employeeDetails(employeeDetails)
                    .deadline(LocalDateTime.now().plusDays(course.getDuration()))
                    .courseStatus(CourseStatus.PENDING)
                    .numberOfLecturesCompleted(0)
                    .build();

            if(employeeDetails.getEnrolledStatus() == EnrolledStatus.NOT_ENROLLED){
                employeeDetails.setEnrolledStatus(EnrolledStatus.ENROLLED);
                employeeDetailsRepository.save(employeeDetails);
            }
            enrollmentRepository.save(enrollment);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Course enrolled successfully";
    }
}
