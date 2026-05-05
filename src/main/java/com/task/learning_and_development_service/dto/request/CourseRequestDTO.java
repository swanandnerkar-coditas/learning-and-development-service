package com.task.learning_and_development_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDTO{

    @NotBlank
    private String name;

    @NotNull
    private Float duration;

    /*
     add lecture DTO here , it'll List,
     and it'll have Lecture
     not required to create separate DTO
     */

    @NotNull
    private List<String> lectures;
}
