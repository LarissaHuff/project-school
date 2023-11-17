package com.projectschool.service;

import com.projectschool.dto.CourseDTO;
import com.projectschool.model.Course;
import com.projectschool.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Long create(CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.name());
        course.setDescription(courseDTO.description());
        course.setAcronym(courseDTO.acronym());

        return courseRepository.save(course).getId();
    }

    public List<Course> findAllByName(String name) {
        if (name == null) {
            return courseRepository.findAll();
        }
        return courseRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    public void update(Long id, CourseDTO courseDTO) {
        Course course = findById(id);
        course.setName(courseDTO.name());
        course.setDescription(courseDTO.description());
        course.setAcronym(courseDTO.acronym());

        courseRepository.save(course);
    }


    public Course findByAcronym(String acronym) {
        return courseRepository.findByAcronym(acronym).orElseThrow();

    }
}
