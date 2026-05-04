package com.task.learning_and_development_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lecture-completion")
@Getter
@Setter
@NoArgsConstructor
public class LectureCompletion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "employee_details_employee_id")
    private EmployeeDetails employeeDetails;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

}
