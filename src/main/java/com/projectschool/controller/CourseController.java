package com.projectschool.controller;

import com.projectschool.dto.CourseDTO;
import com.projectschool.dto.CourseViewDTO;
import com.projectschool.model.Course;
import com.projectschool.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CourseDTO courseDTO) {
        var createdId = courseService.create(courseDTO);
        return ResponseEntity.created(URI.create("/courses/" + createdId)).build();
    }

    @GetMapping
    public List<CourseViewDTO> findAllByName(@RequestParam(required = false) String name) {
        List<Course> courseList = courseService.findAllByName(name);

        return courseList.stream()
                .map(CourseViewDTO::new)
                .toList();

        /*
        var list = new ArrayList<CourseViewDTO>();
        for (Course course : courseList) {
            var courseViewDTO = new CourseViewDTO(course);
            list.add(courseViewDTO);
        }
        return list;
        */
    }

    @GetMapping("/{id}")
    public CourseViewDTO findById(@PathVariable Long id) {

        return new CourseViewDTO(courseService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        courseService.update(id, courseDTO);

    }
}
