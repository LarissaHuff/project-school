package com.projectschool.dto;

import com.projectschool.model.Course;

public record CourseViewDTO(Long id, String name, String description, String acronym) {
    public CourseViewDTO(Course course){
        this(course.getId(), course.getName(), course.getDescription(), course.getAcronym());
    }
}
