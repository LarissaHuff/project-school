package com.projectschool.controller;

import com.projectschool.dto.AssessmentDTO;
import com.projectschool.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @PostMapping
    public void create(@RequestBody AssessmentDTO assessmentDTO) {
        assessmentService.create(assessmentDTO);
    }

}
