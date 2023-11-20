package com.projectschool.dto;

import com.projectschool.enumeration.SubjectClassStatus;
import com.projectschool.model.SubjectClass;

public record SubjectClassViewDTO(Long subjectClassId, Long teacherId, String teacherName, Long subjectId,
                                  String subjectName, Integer availableVacancies, Integer occupiedVacancies, SubjectClassStatus subjectClassStatus) {
    public SubjectClassViewDTO(SubjectClass subjectClass) {
        this(subjectClass.getId(), subjectClass.getTeacher().getId(), subjectClass.getTeacher().getPerson().getName(),
                subjectClass.getSubject().getId(), subjectClass.getSubject().getName(),
                subjectClass.getAvailableVacancies(), subjectClass.occupiedVacancies(), subjectClass.getStatus());

    }
}
