package com.projectschool.dto;

import com.projectschool.model.Subject;

public record SubjectViewDTO(String name, String description) {
    public SubjectViewDTO(Subject subject){
        this(subject.getName(), subject.getDescription());

    }
}
