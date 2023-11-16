package com.projectschool.dto;

import com.projectschool.model.Student;

public record StudentViewDTO(Long personId, String personName, Long courseId, String courseName) {
    public StudentViewDTO(Student student){
        this(student.getPerson().getId(), student.getPerson().getName(),
                student.getCourse().getId(), student.getCourse().getName());
    }
}
