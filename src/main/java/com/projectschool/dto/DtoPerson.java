package com.projectschool.dto;

import com.projectschool.model.Person;
import com.projectschool.service.DocumentType;

import java.time.LocalDate;

public record DtoPerson(String name, LocalDate birthDate, String documentNumber, DocumentType documentType) {
    public DtoPerson(Person person){
        this(person.getName(), person.getBirthDate(), person.getDocumentNumber(), person.getDocumentType());
    }
}


