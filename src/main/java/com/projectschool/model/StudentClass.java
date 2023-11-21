package com.projectschool.model;

import com.projectschool.enumeration.StudentClassStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static com.projectschool.enumeration.StudentClassStatus.REGISTERED;

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

    @Enumerated(EnumType.STRING)
    private StudentClassStatus status = REGISTERED;


}
