package com.task.learning_and_development_service.service;

import com.task.learning_and_development_service.enums.CourseStatus;
import com.task.learning_and_development_service.exception.LectureStatusUpdateException;
import com.task.learning_and_development_service.model.*;
import com.task.learning_and_development_service.repository.EmployeeDetailsRepository;
import com.task.learning_and_development_service.repository.EnrollmentRepository;
import com.task.learning_and_development_service.repository.LectureCompletionRepository;
import com.task.learning_and_development_service.repository.LectureRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService{

    private final LectureRepository lectureRepository;
    private final LectureCompletionRepository lectureCompletionRepository;
    private final EmployeeDetailsRepository employeeDetailsRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Override
    public String startLecture(Long employeeId, Long lectureId) {

        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new EntityNotFoundException("Lecture not found for provided id"));

        Course course = lecture.getCourse();

        EmployeeDetails employeeDetails = employeeDetailsRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found for provided Id"));

        // add lec com repo
        LectureCompletion lectureCompletion = LectureCompletion.builder()
                .course(course)
                .employeeDetails(employeeDetails)
                .lecture(lecture).isComplete(false)
                .build();

        try{
            lectureCompletionRepository.save(lectureCompletion);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "lecture started";
    }

    @Override
    public String markAsCompleteLecture(Long employeeId, Long lectureId) {
        try {
            Lecture lecture = lectureRepository.findById(lectureId)
                    .orElseThrow(() -> new EntityNotFoundException("Lecture not found for provided id"));

            Course course = lecture.getCourse();


            EmployeeDetails employeeDetails = employeeDetailsRepository.findById(employeeId)
                    .orElseThrow(() -> new EntityNotFoundException("Employee not found for provided Id"));

            LectureCompletion lectureCompletion = lectureCompletionRepository.findByEmployeeDetailsAndCourseAndLecture(employeeDetails, course, lecture);

            if (lectureCompletion.getIsComplete()) {
                throw new LectureStatusUpdateException("lecture status is already completed");
            }
            lectureCompletion.setIsComplete(true);

            // change in enrollment
            Enrollment enrollment = enrollmentRepository.findByEmployeeDetailsAndCourse(employeeDetails, course);
            enrollment.setNumberOfLecturesCompleted(enrollment.getNumberOfLecturesCompleted() + 1);

            if(enrollment.getNumberOfLecturesCompleted() == course.getLectures().size()){
                enrollment.setCourseStatus(CourseStatus.COMPLETED);
            }

            lectureCompletionRepository.save(lectureCompletion);
            enrollmentRepository.save(enrollment);
        } catch (Exception e) {
            throw e;
        }
        return "lecture status updated";
    }
}
