package com.projectschool.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class SubjectClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @OneToMany(mappedBy="subjectClass")
    private Set<StudentClass> studentClassSet;
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
    private Integer vacancies;

    public Integer getAvailableVacancies() {
        Integer occupied = studentClassSet.size();
         return vacancies - occupied;
    }

    public Integer occupiedVacancies(){
        return studentClassSet.size();
    }

}
