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
    @JoinColumn(name = "employee_id")
//    private User user;
    private EmployeeDetails employeeDetails;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @Column(name = "is_complete")
    private Boolean isComplete;

}
