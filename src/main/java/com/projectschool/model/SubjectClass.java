package com.projectschool.model;

import com.projectschool.enumeration.SubjectClassStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

import static com.projectschool.enumeration.SubjectClassStatus.OPEN;

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

    @OneToMany(mappedBy = "subjectClass")
    private Set<StudentClass> studentClassSet;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
    private Integer vacancies;

    @Enumerated(EnumType.STRING)
    private SubjectClassStatus status = OPEN;

    @OneToMany(mappedBy = "subjectClass")
    private Set<Assessment> assessments;

    public Integer getAvailableVacancies() {
        Integer occupied = studentClassSet.size();
        return vacancies - occupied;
    }
    public Integer occupiedVacancies() {
        return studentClassSet.size();
    }

}
