package com.projectschool.dto;

import com.projectschool.enumeration.SubjectClassStatus;
import com.projectschool.model.SubjectClass;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record SubjectClassDTO(Long teacherId, Long subjectId, @NotNull @Min(1) Integer vacancies, SubjectClassStatus subjectClassStatus) {
    public SubjectClassDTO(SubjectClass subjectClass) {
        this(subjectClass.getSubject().getId(), subjectClass.getTeacher().getId(), subjectClass.getVacancies(), subjectClass.getStatus());
    }
}
