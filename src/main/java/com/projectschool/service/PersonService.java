package com.projectschool.service;

import com.projectschool.dto.PersonDTO;
import com.projectschool.model.Person;
import com.projectschool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public void registerPerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.name());
        person.setBirthDate(personDTO.birthDate());
        person.setDocumentNumber(personDTO.documentNumber());
        person.setDocumentType(personDTO.documentType());

        personRepository.save(person);
    }

    public List<Person> getAllByName(String name) {
        if (name == null) {
            return personRepository.findAll();
        }
        return personRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Person getById(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public void updatePerson(Long id, PersonDTO personDTO) {
        Person person = getById(id);

        person.setName(personDTO.name());
        person.setBirthDate(personDTO.birthDate());
        person.setDocumentNumber(personDTO.documentNumber());
        person.setDocumentType(personDTO.documentType());

        personRepository.save(person);


    }
}
