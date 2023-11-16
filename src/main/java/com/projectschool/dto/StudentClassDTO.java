package com.projectschool.dto;

import com.projectschool.model.StudentClass;

public record StudentClassDTO(Long studentId, Long subjectClassId) {
    public StudentClassDTO(StudentClass studentClass){
        this(studentClass.getStudent().getId(),studentClass.getSubjectClass().getId());
    }
}
