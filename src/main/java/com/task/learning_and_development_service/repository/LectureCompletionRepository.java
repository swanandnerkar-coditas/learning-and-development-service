package com.task.learning_and_development_service.repository;

import com.task.learning_and_development_service.model.Course;
import com.task.learning_and_development_service.model.EmployeeDetails;
import com.task.learning_and_development_service.model.Lecture;
import com.task.learning_and_development_service.model.LectureCompletion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureCompletionRepository extends JpaRepository<LectureCompletion, Long> {
    LectureCompletion findByEmployeeDetailsAndCourseAndLecture(EmployeeDetails employeeDetails, Course course, Lecture lecture);
}
