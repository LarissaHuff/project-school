package com.projectschool.model;

import com.projectschool.service.DocumentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String documentNumber;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;
}
