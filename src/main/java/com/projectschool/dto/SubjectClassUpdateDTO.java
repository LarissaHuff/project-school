package com.projectschool.dto;

import com.projectschool.enumeration.SubjectClassStatus;
import com.projectschool.model.SubjectClass;

public record SubjectClassUpdateDTO(Integer vacancies, Long teacherId, Long subjectClassId, SubjectClassStatus subjectClassStatus) {
    public SubjectClassUpdateDTO(SubjectClass subjectClass){
        this(subjectClass.getVacancies(), subjectClass.getTeacher().getId(), subjectClass.getId(), subjectClass.getStatus());
    }
}
