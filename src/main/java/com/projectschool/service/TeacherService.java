package com.projectschool.service;

import com.projectschool.dto.TeacherDTO;
import com.projectschool.model.Person;
import com.projectschool.model.Teacher;
import com.projectschool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository repository;
    @Autowired
    private PersonService personService;

    public Long create(TeacherDTO teacherDTO) {
        Person person = personService.findById(teacherDTO.personId());
        Teacher teacher = new Teacher();
        teacher.setPerson(person);
        return repository.save(teacher).getId();
    }

    public Teacher findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Teacher> findAll() {
        return repository.findAll();
    }
}
