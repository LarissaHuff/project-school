package com.projectschool.dto;

import com.projectschool.model.Subject;
import jakarta.validation.constraints.NotBlank;

public record SubjectDTO(
        @NotBlank
        String name,
        @NotBlank
        String description) {
        public SubjectDTO(Subject subject) {
       this(subject.getName(), subject.getDescription());
    }
}
