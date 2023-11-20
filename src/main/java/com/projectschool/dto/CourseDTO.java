package com.projectschool.dto;

import com.projectschool.model.Course;
import jakarta.validation.constraints.NotBlank;

public record CourseDTO(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotBlank
        String acronym) {
    public CourseDTO(Course course){
        this(course.getName(), course.getDescription(), course.getAcronym());
    }
}
