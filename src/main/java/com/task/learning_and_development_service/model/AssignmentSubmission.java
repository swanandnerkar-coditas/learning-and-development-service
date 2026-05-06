package com.task.learning_and_development_service.model;

import com.task.learning_and_development_service.enums.AssignmentStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "assignment-submission")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_submission_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @Enumerated(EnumType.STRING)
    @Column(name = "assignment_status")
    private AssignmentStatus assignmentStatus;

    @ManyToOne
    @JoinColumn(name = "employee_id")
//    private User user;
    private EmployeeDetails employeeDetails;

    @Column(name = "github_link", nullable = false)
    private String gitHubLink;
}
