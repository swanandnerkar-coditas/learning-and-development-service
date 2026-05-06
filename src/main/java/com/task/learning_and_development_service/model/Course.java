package com.task.learning_and_development_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "course")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String name;

    // add duration : take in hours ( float to int )
    private Integer duration;

    @OneToMany(mappedBy = "course")
    @Column(name = "enrollment_id")
    private List<Enrollment> enrollments;

    @OneToOne(mappedBy = "course")
    private Assignment assignment;

    @OneToMany(mappedBy = "course")
    private List<Lecture> lectures;
}
