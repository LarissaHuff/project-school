package com.projectschool.controller;

import com.projectschool.dto.StudentClassDTO;
import com.projectschool.dto.StudentClassViewDTO;
import com.projectschool.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student-class")
public class StudentClassController {

    @Autowired
    StudentClassService studentClassService;

    @GetMapping("/student/{studentId}")
    public List<StudentClassViewDTO> findAllByStudentId(@RequestBody @PathVariable Long studentId){
        return studentClassService.findAllByStudentId(studentId).stream()
                .map(StudentClassViewDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void register(@RequestBody StudentClassDTO studentClassDTO){
        studentClassService.register(studentClassDTO);

    }

}
