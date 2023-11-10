package com.projectschool.dto;

import com.projectschool.model.Course;

public record CourseDTO(String name, String description, String acronym) {
    public CourseDTO(Course course){
        this(course.getName(), course.getDescription(), course.getAcronym());
    }
}
