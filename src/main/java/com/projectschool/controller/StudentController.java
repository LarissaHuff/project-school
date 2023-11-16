package com.projectschool.controller;

import com.projectschool.dto.StudentDTO;
import com.projectschool.dto.StudentViewDTO;
import com.projectschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public void register(@RequestBody StudentDTO studentDTO){
        studentService.register(studentDTO);
    }

    @GetMapping("/{id}")
    public StudentViewDTO findById(@PathVariable Long id){
       return new StudentViewDTO(studentService.findById(id));
    }
}
