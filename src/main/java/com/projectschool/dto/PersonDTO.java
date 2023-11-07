package com.projectschool.dto;

import com.projectschool.model.Person;
import com.projectschool.service.DocumentType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public record PersonDTO(String name, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
                        String documentNumber, DocumentType documentType) {

    public PersonDTO(Person person) {
        this(person.getName(), person.getBirthDate(), person.getDocumentNumber(), person.getDocumentType());
    }
}


