package com.projectschool.dto;

import com.projectschool.model.Subject;

public record SubjectViewDTO(Long id, String name, String description) {
    public SubjectViewDTO(Subject subject){
        this(subject.getId(), subject.getName(), subject.getDescription());
    }
}
