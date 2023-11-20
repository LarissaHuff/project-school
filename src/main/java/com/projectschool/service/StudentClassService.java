package com.projectschool.service;

import com.projectschool.dto.StudentClassDTO;
import com.projectschool.enumeration.SubjectClassStatus;
import com.projectschool.exception.BusinessException;
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
    private StudentClassRepository studentClassRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectClassService subjectClassService;

    public void create(StudentClassDTO studentClassDTO) {
        SubjectClass subjectClass = subjectClassService.findById(studentClassDTO.subjectClassId());

        validateStudentClass(subjectClass);

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

    private void validateStudentClass(SubjectClass subjectClass) {
        Integer vacancies = subjectClass.getAvailableVacancies();

        if (subjectClass.getStatus() != SubjectClassStatus.OPEN) {
            throw new BusinessException("Class is not in a valid status to register new students.");
        }

        if (vacancies == 0) {
            throw new BusinessException("No vacancies available for this class.");
        }
    }
}
