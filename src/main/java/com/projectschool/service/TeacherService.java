package com.projectschool.service;

import com.projectschool.dto.TeacherDTO;
import com.projectschool.model.Person;
import com.projectschool.model.Teacher;
import com.projectschool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository repository;

    @Autowired
    private PersonService personService;

    public void register(TeacherDTO teacherDTO) {
        Person person = personService.getById(teacherDTO.personId());

        Teacher teacher = new Teacher();
        teacher.setPerson(person);

        repository.save(teacher);

    }

    public Teacher findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

}
