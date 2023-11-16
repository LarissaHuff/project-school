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
    StudentRepository studentRepository;
    @Autowired
    PersonService personService;
    @Autowired
    CourseService courseService;

    public void register(StudentDTO studentDTO) {
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
        student.setPerson(personService.getById(studentDTO.personId()));
        student.setCourse(course);

        studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();

    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
