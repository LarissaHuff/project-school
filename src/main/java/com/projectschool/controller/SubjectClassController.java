package com.projectschool.controller;

import com.projectschool.dto.StudentViewDTO;
import com.projectschool.dto.SubjectClassDTO;
import com.projectschool.dto.SubjectClassUpdateDTO;
import com.projectschool.dto.SubjectClassViewDTO;
import com.projectschool.model.SubjectClass;
import com.projectschool.service.SubjectClassService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/classes")
public class SubjectClassController {
    @Autowired
    private SubjectClassService classService;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody SubjectClassDTO subjectClassDTO) {
        Long createdId = classService.create(subjectClassDTO);
        return ResponseEntity.created(URI.create("/classes/" + createdId)).build();
    }

    @GetMapping("/{id}")
    public SubjectClassViewDTO findById(@PathVariable Long id) {
        return new SubjectClassViewDTO(classService.findById(id));

    }

    @GetMapping("/subject/{subjectId}")
    public Set<SubjectClassViewDTO> findAllBySubject(@PathVariable Long subjectId) {
        return classService.findAllBySubject(subjectId).stream()
                .map(SubjectClassViewDTO::new)
                .collect(Collectors.toSet());
    }

    @GetMapping("/teacher/{teacherId}")
    public List<SubjectClassViewDTO> findAllByTeacher(@PathVariable Long teacherId) {
        return classService.findAllByTeacher(teacherId).stream()
                .map(SubjectClassViewDTO::new)
                .toList();
    }

    @GetMapping
    public List<SubjectClassViewDTO> findAll() {
        List<SubjectClass> classList = classService.findAll();
        return classList.stream()
                .map(SubjectClassViewDTO::new)
                .toList();
    }

    @GetMapping("/{id}/students")
    public List<StudentViewDTO> findAllStudentsByClass(@PathVariable Long id) {
        return classService.findAllStudentsByClass(id).stream()
                .map(StudentViewDTO::new)
                .toList();

    }

    @PutMapping("/{subjectClassId}")
    public void update(@RequestBody SubjectClassUpdateDTO updateDTO, @PathVariable Long subjectClassId) {
        classService.update(updateDTO, subjectClassId);
    }


}
