package com.projectschool.service;

import com.projectschool.dto.StudentDTO;
import com.projectschool.model.Student;
import com.projectschool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PersonService personService;
    @Autowired
    CourseService courseService;

    public void register(StudentDTO studentDTO){
        Student student = new Student();
        student.setPerson(personService.getById(studentDTO.personId()));
        student.setCourse(courseService.findById(studentDTO.courseId()));

        studentRepository.save(student);
    }

    public Student findById(Long id){
        return studentRepository.findById(id).orElseThrow();

    }
}
