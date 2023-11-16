package com.projectschool.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class StudentClass {

    @EmbeddedId
    StudentClassKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @MapsId("subjectClassId")
    @JoinColumn(name = "subject_class_id", nullable = false)
    private SubjectClass subjectClass;


}
