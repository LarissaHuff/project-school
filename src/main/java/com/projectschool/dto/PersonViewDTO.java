package com.projectschool.dto;

import com.projectschool.model.Person;
import com.projectschool.enumeration.DocumentType;

import java.time.LocalDate;

public record PersonViewDTO(String name, LocalDate birthDate,
                            String documentNumber, DocumentType documentType, Long personId) {
    public PersonViewDTO(Person person){
        this(person.getName(), person.getBirthDate(), person.getDocumentNumber(), person.getDocumentType(), person.getId());
    }
}
