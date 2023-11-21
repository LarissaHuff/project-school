package com.projectschool.dto;

import com.projectschool.enumeration.StudentClassStatus;
import com.projectschool.model.StudentClass;

public record StudentClassStatusDTO(StudentClassStatus studentClassStatus) {
    public StudentClassStatusDTO(StudentClass studentClass){
        this(studentClass.getStatus());
    }
}
