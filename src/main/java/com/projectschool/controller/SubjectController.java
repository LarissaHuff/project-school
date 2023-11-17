package com.projectschool.controller;

import com.projectschool.dto.SubjectDTO;
import com.projectschool.dto.SubjectViewDTO;
import com.projectschool.model.Subject;
import com.projectschool.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SubjectDTO subjectDTO) {
        Long createdId= subjectService.create(subjectDTO);
        return ResponseEntity.created(URI.create("/subjects/" + createdId)).build();
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
