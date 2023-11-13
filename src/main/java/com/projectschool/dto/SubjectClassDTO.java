package com.projectschool.dto;

import com.projectschool.model.SubjectClass;

public record SubjectClassDTO(Long teacherId, Long subjectId) {
    public SubjectClassDTO(SubjectClass subjectClass){
        this(subjectClass.getSubject().getId(),subjectClass.getTeacher().getId());
    }
}
