package com.projectschool.controller;

import com.projectschool.dto.SubjectDTO;
import com.projectschool.dto.SubjectViewDTO;
import com.projectschool.model.Subject;
import com.projectschool.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<SubjectViewDTO> findAllByName(@RequestParam(required = false) String name) {
        List<Subject> subjectList = subjectService.findAllByName(name);
        return subjectList.stream()
                .map(it -> new SubjectViewDTO(it))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SubjectViewDTO findById(@PathVariable Long id) {

        return new SubjectViewDTO(subjectService.findById(id));

    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        subjectService.delete(id);
    }

}
