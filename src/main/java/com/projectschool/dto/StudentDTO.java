package com.projectschool.dto;

import com.projectschool.model.Student;

public record StudentDTO(Long personId, Long courseId) {

    public StudentDTO(Student student){
        this(student.getPerson().getId(), student.getCourse().getId());
    }
}
