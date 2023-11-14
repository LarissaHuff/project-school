package com.projectschool.service;

import com.projectschool.dto.SubjectClassDTO;
import com.projectschool.model.Subject;
import com.projectschool.model.SubjectClass;
import com.projectschool.model.Teacher;
import com.projectschool.repository.SubjectClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

        repository.save(subjectClass);
    }

    public Set<SubjectClass>findAllBySubject(Long subjectId){
       Subject subject = subjectService.findById(subjectId);
       return subject.getSubjectClasses();

    }

    public Set<SubjectClass> findAllByTeacher(Long teacherId){
       Teacher teacher = teacherService.findById(teacherId);
       return teacher.getSubjectClass();
    }

    public List<SubjectClass>findAll(){
       return repository.findAll();
    }
}
