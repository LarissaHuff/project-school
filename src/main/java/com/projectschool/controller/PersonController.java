package com.projectschool.controller;

import com.projectschool.dto.PersonDTO;
import com.projectschool.dto.PersonViewDTO;
import com.projectschool.model.Person;
import com.projectschool.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody PersonDTO personDTO) {
        Long createdId = personService.createPerson(personDTO);
        return ResponseEntity.created(URI.create("/persons/" + createdId)).build();
    }

    @GetMapping
    public List<PersonViewDTO> getAllByName(@RequestParam(required = false) String name) {
        List<Person> personList = personService.findAllByName(name);

        return personList.stream()
                .map(PersonViewDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public PersonViewDTO getById(@PathVariable Long id) {
        return new PersonViewDTO(personService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        personService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        personService.updatePerson(id, personDTO);
    }
}
