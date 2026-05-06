package com.task.learning_and_development_service.repository;

import com.task.learning_and_development_service.model.Course;
import com.task.learning_and_development_service.model.EmployeeDetails;
import com.task.learning_and_development_service.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Enrollment findByEmployeeDetailsAndCourse(EmployeeDetails employeeDetails, Course course);
}
