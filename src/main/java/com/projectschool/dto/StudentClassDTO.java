package com.projectschool.dto;

import com.projectschool.enumeration.StudentClassStatus;
import com.projectschool.model.StudentClass;

public record StudentClassDTO(Long studentId, Long subjectClassId, StudentClassStatus status) {
    public StudentClassDTO(StudentClass studentClass){
        this(studentClass.getStudent().getId(),studentClass.getSubjectClass().getId(), studentClass.getStatus());
    }
}
