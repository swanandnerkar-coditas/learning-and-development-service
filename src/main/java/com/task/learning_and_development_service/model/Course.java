package com.task.learning_and_development_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String name;

    // add duration
//    private -- duration

    @OneToMany(mappedBy = "course")
    @Column(name = "enrollment_id")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "course")
    @Column(name = "assignment_id")
    private List<Assignment> assignments;

    @OneToMany(mappedBy = "course")
    private List<Lecture> lectures;
}
