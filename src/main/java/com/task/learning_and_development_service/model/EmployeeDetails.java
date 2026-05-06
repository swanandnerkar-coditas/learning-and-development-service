package com.task.learning_and_development_service.model;

import com.task.learning_and_development_service.enums.EmployeeStatus;
import com.task.learning_and_development_service.enums.EnrolledStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "employee-details")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_status")
    private EmployeeStatus employeeStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "course_enrolled_status")
    private EnrolledStatus enrolledStatus;

    @OneToMany(mappedBy = "employeeDetails")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "employeeDetails")
    @Column(name = "assignment_submission_id")
    private List<AssignmentSubmission> assignmentSubmissions;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
