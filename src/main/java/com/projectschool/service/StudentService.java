package com.projectschool.service;

import com.projectschool.dto.StudentDTO;
import com.projectschool.model.Course;
import com.projectschool.model.Student;
import com.projectschool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PersonService personService;
    @Autowired
    private CourseService courseService;

    public Long create(StudentDTO studentDTO) {
        Course course = courseService.findById(studentDTO.courseId());

        boolean thisPersonIsInThisCourse = course.getStudents().stream()
                .map(it -> it.getPerson())
                .filter(it -> it.getId().equals(studentDTO.personId()))
                .count() > 0;

        /*Boolean thereIsAPersonWithSameIdInTheCourse = course.getStudents().stream()
                .map(Student::getPerson)
                .anyMatch(it->it.getId().equals(studentDTO.personId()));*/

        if (thisPersonIsInThisCourse) {
            throw new RuntimeException("Person already registered in this course.");
        }

        Student student = new Student();
        student.setPerson(personService.findById(studentDTO.personId()));
        student.setCourse(course);

        return studentRepository.save(student).getId();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();

    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
