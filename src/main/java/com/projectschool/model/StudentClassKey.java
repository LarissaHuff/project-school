package com.projectschool.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class StudentClassKey implements Serializable {

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "subject_class_id")
    private Long subjectClassId;

}
