package com.projectschool.controller;

import com.projectschool.dto.SubjectClassDTO;
import com.projectschool.dto.SubjectClassViewDTO;
import com.projectschool.model.SubjectClass;
import com.projectschool.service.SubjectClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/classes")
public class SubjectClassController {
    @Autowired
    private SubjectClassService classService;

    @PostMapping
    public void register(@RequestBody SubjectClassDTO subjectClassDTO) {
       classService.register(subjectClassDTO);
    }

    @GetMapping
    public Set<SubjectClassViewDTO> findAllBySubject(@RequestParam Long subjectId){

        return classService.findAllBySubject(subjectId).stream()
                .map(SubjectClassViewDTO::new)
                .collect(Collectors.toSet());
    }



}
