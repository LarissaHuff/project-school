package com.projectschool.controller;

import com.projectschool.dto.PersonDTO;
import com.projectschool.model.Person;
import com.projectschool.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    public void register(@RequestBody PersonDTO personDTO) {
        personService.registerPerson(personDTO);
    }

    @GetMapping
    public List<Person> getAllByName(@RequestParam(required = false) String name) {
        return personService.getAllByName(name);
    }


    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        personService.deleteById(id);
    }
}
