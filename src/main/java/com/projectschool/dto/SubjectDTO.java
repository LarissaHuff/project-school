package com.projectschool.dto;

import com.projectschool.model.Subject;

public record SubjectDTO(String name, String description) {
        public SubjectDTO(Subject subject) {
       this(subject.getName(), subject.getDescription());
    }
}
