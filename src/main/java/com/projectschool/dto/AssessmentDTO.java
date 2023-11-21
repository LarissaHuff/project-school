package com.projectschool.dto;

import com.projectschool.model.Assessment;

public record AssessmentDTO(String title, String description, Long subjectClassId) {
    public AssessmentDTO(Assessment assessment) {
        this(assessment.getTitle(), assessment.getTitle(), assessment.getId());
    }
}
