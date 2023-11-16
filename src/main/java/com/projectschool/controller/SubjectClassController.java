package com.projectschool.controller;

import com.projectschool.dto.StudentViewDTO;
import com.projectschool.dto.SubjectClassDTO;
import com.projectschool.dto.SubjectClassViewDTO;
import com.projectschool.model.Student;
import com.projectschool.model.SubjectClass;
import com.projectschool.service.SubjectClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<SubjectClass> findAll() {
        return classService.findAll();
    }

    @GetMapping("/{id}/students")
    public List<StudentViewDTO> findAllStudentsByClass(@PathVariable Long id) {
        return classService.findAllStudentsByClass(id).stream()
                .map(StudentViewDTO::new)
                .collect(Collectors.toList());

    }
}
