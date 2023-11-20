package com.projectschool.service;

import com.projectschool.dto.SubjectClassDTO;
import com.projectschool.dto.SubjectClassUpdateDTO;
import com.projectschool.exception.NotFoundException;
import com.projectschool.model.*;
import com.projectschool.repository.SubjectClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SubjectClassService {
    @Autowired
    private SubjectClassRepository repository;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;

    public Long create(SubjectClassDTO subjectClassDTO) {

        Subject subject = subjectService.findById(subjectClassDTO.subjectId());
        Teacher teacher = teacherService.findById(subjectClassDTO.teacherId());

        SubjectClass subjectClass = new SubjectClass();
        subjectClass.setTeacher(teacher);
        subjectClass.setSubject(subject);
        subjectClass.setVacancies(subjectClassDTO.vacancies());
        subjectClass.setStatus(subjectClassDTO.subjectClassStatus());

        return repository.save(subjectClass).getId();
    }

    public SubjectClass findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subject Class"));
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
                .toList();
    }

    public void update(SubjectClassUpdateDTO updateDTO, Long subjectClassId) {
        SubjectClass subjectClass = findById(subjectClassId);

        Teacher teacher = teacherService.findById(updateDTO.teacherId());

        subjectClass.setVacancies(updateDTO.vacancies());
        subjectClass.setTeacher(teacher);
        subjectClass.setStatus(updateDTO.subjectClassStatus());

        repository.save(subjectClass);
    }
}
