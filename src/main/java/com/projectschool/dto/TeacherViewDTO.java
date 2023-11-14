package com.projectschool.dto;

import com.projectschool.model.Teacher;

public record TeacherViewDTO(Long teacherId, Long personId, String personName) {
    public TeacherViewDTO(Teacher teacher) {
        this(teacher.getId(), teacher.getPerson().getId(), teacher.getPerson().getName());
    }
}
