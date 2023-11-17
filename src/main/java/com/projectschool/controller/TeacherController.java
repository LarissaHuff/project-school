package com.projectschool.controller;

import com.projectschool.dto.TeacherDTO;
import com.projectschool.dto.TeacherViewDTO;
import com.projectschool.model.Teacher;
import com.projectschool.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TeacherDTO teacherDTO) {
        Long createdId = teacherService.create(teacherDTO);
        return ResponseEntity.created(URI.create("/teachers/" + createdId)).build();
    }

    @GetMapping("/{id}")
    public TeacherViewDTO findById(@PathVariable Long id) {
        Teacher teacher = teacherService.findById(id);
        return new TeacherViewDTO(teacher);
    }

    @GetMapping
    public List<TeacherViewDTO> findAll() {
        List<Teacher> allTeachers = teacherService.findAll();
        return allTeachers.stream()
                .map(TeacherViewDTO::new)
                .toList();
    }
}
