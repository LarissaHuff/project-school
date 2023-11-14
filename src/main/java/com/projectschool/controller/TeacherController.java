package com.projectschool.controller;

import com.projectschool.dto.TeacherDTO;
import com.projectschool.dto.TeacherViewDTO;
import com.projectschool.model.Teacher;
import com.projectschool.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping
    public void register(@RequestBody TeacherDTO teacherDTO) {
        teacherService.register(teacherDTO);
    }

    @GetMapping("/{id}")
    public TeacherViewDTO findById(@PathVariable Long id) {
        Teacher teacher = teacherService.findById(id);
        return new TeacherViewDTO(teacher);
    }
}
