package com.projectschool.dto;

import com.projectschool.model.Teacher;

public record TeacherDTO(Long personId) {
    public TeacherDTO(Teacher teacher){
        this(teacher.getPerson().getId());
    }
}
