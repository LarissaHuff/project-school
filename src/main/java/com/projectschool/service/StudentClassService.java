package com.projectschool.service;

import com.projectschool.dto.StudentClassDTO;
import com.projectschool.model.Student;
import com.projectschool.model.StudentClass;
import com.projectschool.model.StudentClassKey;
import com.projectschool.model.SubjectClass;
import com.projectschool.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentClassService {
    @Autowired
    StudentClassRepository studentClassRepository;
    @Autowired
    StudentService studentService;
    @Autowired
    SubjectClassService subjectClassService;

    public void register(StudentClassDTO studentClassDTO) {
        SubjectClass subjectClass = subjectClassService.findById(studentClassDTO.subjectClassId());
        Integer vacancies = subjectClass.getAvailableVacancies();

        if (vacancies == 0){
            throw new RuntimeException("No vacancies available for this class.");
        }

        Student student = studentService.findById(studentClassDTO.studentId());

        StudentClass studentClass = new StudentClass();
        studentClass.setStudent(student);
        studentClass.setSubjectClass(subjectClass);

        StudentClassKey studentClassKey = new StudentClassKey();
        studentClassKey.setStudentId(studentClassDTO.studentId());
        studentClassKey.setSubjectClassId(studentClassDTO.subjectClassId());

        studentClass.setId(studentClassKey);

        studentClassRepository.save(studentClass);
    }

    public List<StudentClass> findAllByStudentId(Long studentId) {
        return studentClassRepository.findAllByStudentId(studentId);
    }

}
