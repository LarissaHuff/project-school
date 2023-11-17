package com.projectschool.controller;

import com.projectschool.dto.CourseSubjectDTO;
import com.projectschool.dto.CourseSubjectViewDTO;
import com.projectschool.dto.SubjectByCourseViewDTO;
import com.projectschool.model.CourseSubject;
import com.projectschool.model.CourseSubjectKey;
import com.projectschool.service.CourseSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/course-subjects")
@RestController
public class CourseSubjectController {
    @Autowired
    private CourseSubjectService courseSubjectService;

    @PostMapping
    public void create(@RequestBody CourseSubjectDTO courseSubjectDTO) {
        courseSubjectService.create(courseSubjectDTO);
    }

    @GetMapping
    public List<CourseSubjectViewDTO> findAll() {
        List<CourseSubject> courseSubjectList = courseSubjectService.findAll();

        return courseSubjectList.stream()
                .map(CourseSubjectViewDTO::new)
                .toList();
    }

    @GetMapping("/course/{acronym}/subjects")
    public List<SubjectByCourseViewDTO> findAllByCourse(@PathVariable String acronym, @RequestParam(required = false) String semester) {

        List<CourseSubject> allSubjectsByCourse = courseSubjectService.findAllSubjectsByCourse(acronym, semester);

        return allSubjectsByCourse.stream()
                .map(SubjectByCourseViewDTO::new)
                .sorted(Comparator.comparing(SubjectByCourseViewDTO::semester))
                .filter(it -> semester == null || it.semester().equals(semester))
                .toList();
    }

    @GetMapping("/{id}")
    public CourseSubjectViewDTO findById(@PathVariable CourseSubjectKey courseSubjectKey) {
        return new CourseSubjectViewDTO(courseSubjectService.findById(courseSubjectKey));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable CourseSubjectKey courseSubjectKey) {
        courseSubjectService.deleteById(courseSubjectKey);
    }
}

