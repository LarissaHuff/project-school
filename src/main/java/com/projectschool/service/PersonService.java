package com.projectschool.service;

import com.projectschool.Repository.PersonRepository;
import com.projectschool.dto.DtoPerson;
import com.projectschool.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public void registerPerson(DtoPerson dtoPerson){
        Person person = new Person();
        person.setName(dtoPerson.name());
        person.setBirthDate(dtoPerson.birthDate());
        person.setDocumentNumber(dtoPerson.documentNumber());
        person.setDocumentType(dtoPerson.documentType());
        personRepository.save(person);

    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public List<Person> getByName(String name){
        return  personRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Person getByid(Long id){
        return personRepository.findById(id).orElseThrow();
    }

    public void deleteById(Long id){
        personRepository.deleteById(id);
    }


}
