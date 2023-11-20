package com.projectschool.dto;

import com.projectschool.model.Person;
import com.projectschool.enumeration.DocumentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public record PersonDTO(
        @NotBlank
        String name,
        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate birthDate,
        @NotBlank
        String documentNumber,
        @NotNull
        DocumentType documentType) {

    public PersonDTO(Person person) {
        this(person.getName(), person.getBirthDate(), person.getDocumentNumber(), person.getDocumentType());
    }
}


