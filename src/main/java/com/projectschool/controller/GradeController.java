package com.projectschool.controller;

import com.projectschool.dto.GradeDTO;
import com.projectschool.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping
    public void create (@RequestBody GradeDTO gradeDTO){
        gradeService.create(gradeDTO);

    }


}
