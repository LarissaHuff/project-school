package com.projectschool.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Teacher {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="teacher")
    private Set<SubjectClass> subjectClass;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
}
