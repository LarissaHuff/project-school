package com.projectschool.dto;

import com.projectschool.model.StudentClass;

public record StudentClassViewDTO(Long studentId, String studentName, Long subjectClassId, String subjectName) {
    public StudentClassViewDTO(StudentClass studentClass){
        this(studentClass.getStudent().getId(), studentClass.getStudent().getPerson().getName(),
                studentClass.getSubjectClass().getId(),
                studentClass.getSubjectClass().getSubject().getName());
    }
}
