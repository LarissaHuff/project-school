package com.projectschool.service;

import com.projectschool.dto.AssessmentDTO;
import com.projectschool.exception.NotFoundException;
import com.projectschool.model.Assessment;
import com.projectschool.model.SubjectClass;
import com.projectschool.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentService {
    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private SubjectClassService subjectClassesService;

    public void create(AssessmentDTO assessmentDTO) {
        Assessment assessment = new Assessment();
        assessment.setTitle(assessmentDTO.title());
        assessment.setDescription(assessmentDTO.description());

        SubjectClass subjectClass = subjectClassesService.findById(assessmentDTO.subjectClassId());
        assessment.setSubjectClass(subjectClass);

        assessmentRepository.save(assessment);
    }

    public Assessment findById(Long id) {
        return assessmentRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Assessment"));

    }
}
