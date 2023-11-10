package com.projectschool.controller;

import com.projectschool.dto.CourseSubjectDTO;
import com.projectschool.dto.CourseSubjectViewDTO;
import com.projectschool.dto.SubjectByCourseViewDTO;
import com.projectschool.model.CourseSubjectKey;
import com.projectschool.service.CourseSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/course-subject")
@RestController
public class CourseSubjectController {
    @Autowired
    CourseSubjectService courseSubjectService;

    @PostMapping
    public void register(@RequestBody CourseSubjectDTO courseSubjectDTO) {

        courseSubjectService.register(courseSubjectDTO);

    }

    @GetMapping
    public List<CourseSubjectViewDTO> getAll(){
       return courseSubjectService.getAll();
    }

    @GetMapping("/course/{acronym}/subjects")
    public List<SubjectByCourseViewDTO> getAllByCourse(@PathVariable String acronym, @RequestParam(required = false) String semester){
        return courseSubjectService.getAllSubjectsByCourse(acronym, semester);
    }

    @GetMapping("/{id}")
    public CourseSubjectViewDTO getById(@PathVariable CourseSubjectKey courseSubjectKey) {
        return courseSubjectService.getById(courseSubjectKey);
    }


}
