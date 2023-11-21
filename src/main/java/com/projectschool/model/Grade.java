package com.projectschool.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Setter
@Getter
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer value;

    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "student_id"),
            @JoinColumn(name = "subject_class_id")
    })
    private StudentClass studentClass;

    @ManyToOne
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;

}
