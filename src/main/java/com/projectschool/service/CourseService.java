package com.projectschool.service;

import com.projectschool.dto.CourseDTO;
import com.projectschool.model.Course;
import com.projectschool.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public void register(CourseDTO courseDTO){
        Course course = new Course();
        course.setName(courseDTO.name());
        course.setDescription(courseDTO.description());
        course.setAcronym(courseDTO.acronym());

        courseRepository.save(course);
    }


}
