package com.task.learning_and_development_service.model;

import com.task.learning_and_development_service.enums.AssignmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "assignment")
@Getter
@Setter
@NoArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    private Long id;

    @Column(name = "problem_statement", nullable = false)
    private String problemStatement;

    @OneToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

}
