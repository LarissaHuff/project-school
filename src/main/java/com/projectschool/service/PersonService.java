package com.projectschool.service;

import com.projectschool.dto.PersonDTO;
import com.projectschool.exception.NotFoundException;
import com.projectschool.model.Person;
import com.projectschool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Long createPerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.name());
        person.setBirthDate(personDTO.birthDate());
        person.setDocumentNumber(personDTO.documentNumber());
        person.setDocumentType(personDTO.documentType());

        return personRepository.save(person).getId();
    }

    public List<Person> findAllByName(String name) {
        if (name == null) {
            return personRepository.findAll();
        }
        return personRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person"));
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public void updatePerson(Long id, PersonDTO personDTO) {
        Person person = findById(id);

        person.setName(personDTO.name());
        person.setBirthDate(personDTO.birthDate());
        person.setDocumentNumber(personDTO.documentNumber());
        person.setDocumentType(personDTO.documentType());

        personRepository.save(person);


    }
}
