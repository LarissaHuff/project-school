package com.projectschool.controller;

import com.projectschool.dto.StudentDTO;
import com.projectschool.dto.StudentViewDTO;
import com.projectschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<StudentViewDTO> findAll(){
        return studentService.findAll().stream()
                .map(StudentViewDTO::new)
                .collect(Collectors.toList());
    }
}


