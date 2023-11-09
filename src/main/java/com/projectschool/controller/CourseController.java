package com.projectschool.controller;

import com.projectschool.dto.CourseDTO;
import com.projectschool.model.Course;
import com.projectschool.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping
    public void register(@RequestBody CourseDTO courseDTO) {
        courseService.register(courseDTO);
    }

    @GetMapping
    public List<Course> getAllByName(@RequestParam(required = false) String name) {
        return courseService.getAllByName(name);
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        courseService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CourseDTO courseDTO){
        courseService.update(id, courseDTO);

    }


}
