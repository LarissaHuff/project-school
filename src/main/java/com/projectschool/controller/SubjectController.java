package com.projectschool.controller;

import com.projectschool.dto.SubjectDTO;
import com.projectschool.model.Subject;
import com.projectschool.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @PostMapping
    public void register(@RequestBody SubjectDTO subjectDTO) {
        subjectService.register(subjectDTO);
    }

    @PutMapping("/{id}")
    public void updateSubject(@PathVariable Long id, @RequestBody SubjectDTO subjectDTO) {
        subjectService.updateSubject(id, subjectDTO);
    }

    @GetMapping
    public List<Subject> findAllByName(@RequestParam(required = false) String name) {
        return subjectService.findAllByName(name);
    }

    @GetMapping("/{id}")
    public Subject findById(@PathVariable Long id) {
        return subjectService.findById(id);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        subjectService.delete(id);
    }

}
