package com.projectschool.service;

import com.projectschool.dto.GradeDTO;
import com.projectschool.model.Assessment;
import com.projectschool.model.Grade;
import com.projectschool.model.StudentClass;
import com.projectschool.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentClassService studentClassService;

    @Autowired
    private AssessmentService assessmentService;

    public void create(GradeDTO gradeDTO) {

        Assessment assessment = assessmentService.findById(gradeDTO.assessmentId());

        StudentClass studentClass = studentClassService.findById(gradeDTO.studentId(),
                assessment.getSubjectClass().getId());

        Grade grade = new Grade();
        grade.setValue(gradeDTO.value());
        grade.setStudentClass(studentClass);
        grade.setAssessment(assessment);

        gradeRepository.save(grade);
    }
}
