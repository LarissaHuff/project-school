package com.projectschool.controller;

import com.projectschool.dto.CourseDTO;
import com.projectschool.dto.CourseViewDTO;
import com.projectschool.model.Course;
import com.projectschool.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody CourseDTO courseDTO) {
        var createdId = courseService.register(courseDTO);
        return ResponseEntity.created(URI.create("/courses/" + createdId)).build();
    }

    @GetMapping
    public List<CourseViewDTO> getAllByName(@RequestParam(required = false) String name) {
        List<Course> courseList = courseService.getAllByName(name);

        return courseList.stream()
                .map(CourseViewDTO::new)
                .collect(Collectors.toList());

        /*var list = new ArrayList<CourseViewDTO>();
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
