package com.projectschool.controller;

import com.projectschool.dto.StudentDTO;
import com.projectschool.dto.StudentViewDTO;
import com.projectschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody StudentDTO studentDTO){
        Long createdId = studentService.create(studentDTO);
        return ResponseEntity.created(URI.create("/students/" + createdId)).build();
    }

    @GetMapping("/{id}")
    public StudentViewDTO findById(@PathVariable Long id){
       return new StudentViewDTO(studentService.findById(id));
    }

    @GetMapping
    public List<StudentViewDTO> findAll(){
        return studentService.findAll().stream()
                .map(StudentViewDTO::new)
                .toList();
    }
}


