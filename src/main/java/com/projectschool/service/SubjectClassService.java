package com.projectschool.service;

import com.projectschool.dto.SubjectClassDTO;
import com.projectschool.model.*;
import com.projectschool.repository.SubjectClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubjectClassService {
    @Autowired
    SubjectClassRepository repository;

    @Autowired
    TeacherService teacherService;

    @Autowired
    SubjectService subjectService;

    public void register(SubjectClassDTO subjectClassDTO) {

        Subject subject = subjectService.findById(subjectClassDTO.subjectId());
        Teacher teacher = teacherService.findById(subjectClassDTO.teacherId());

        SubjectClass subjectClass = new SubjectClass();
        subjectClass.setTeacher(teacher);
        subjectClass.setSubject(subject);
        subjectClass.setVacancies(subjectClassDTO.vacancies());

        repository.save(subjectClass);
    }

    public SubjectClass findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Set<SubjectClass> findAllBySubject(Long subjectId) {
        Subject subject = subjectService.findById(subjectId);
        return subject.getSubjectClasses();

    }

    public Set<SubjectClass> findAllByTeacher(Long teacherId) {
        Teacher teacher = teacherService.findById(teacherId);
        return teacher.getSubjectClass();
    }

    public List<SubjectClass> findAll() {
        return repository.findAll();
    }

    public List<Student> findAllStudentsByClass(Long id) {
        return findById(id).getStudentClassSet().stream()
                .map(StudentClass::getStudent)
                .collect(Collectors.toList());
    }
}
