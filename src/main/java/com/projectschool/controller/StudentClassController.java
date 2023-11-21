package com.projectschool.controller;

import com.projectschool.dto.StudentClassDTO;
import com.projectschool.dto.StudentClassStatusDTO;
import com.projectschool.dto.StudentClassViewDTO;
import com.projectschool.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-classes")
public class StudentClassController {

    @Autowired
    private StudentClassService studentClassService;

    @PostMapping
    public void create(@RequestBody StudentClassDTO studentClassDTO) {
        studentClassService.create(studentClassDTO);

    }

    @GetMapping("/student/{studentId}")
    public List<StudentClassViewDTO> findAllByStudentId(@RequestBody @PathVariable Long studentId) {
        return studentClassService.findAllByStudentId(studentId).stream()
                .map(StudentClassViewDTO::new)
                .toList();
    }

    @PutMapping("/student/{studentId}/classes/{subjectClassId}")
    public void update(@RequestBody StudentClassStatusDTO statusDTO, @PathVariable Long studentId, @PathVariable Long subjectClassId) {
        studentClassService.update(statusDTO, studentId, subjectClassId);
    }
}
