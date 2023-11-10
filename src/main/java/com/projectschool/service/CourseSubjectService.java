package com.projectschool.service;

import com.projectschool.dto.CourseSubjectViewDTO;
import com.projectschool.model.CourseSubject;
import com.projectschool.dto.CourseSubjectDTO;
import com.projectschool.model.CourseSubjectKey;
import com.projectschool.repository.CourseSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseSubjectService {
    @Autowired
    CourseSubjectRepository courseSubjectRepository;
    @Autowired
    CourseService courseService;
    @Autowired
    SubjectService subjectService;

    public void register(CourseSubjectDTO courseSubjectDTO){
        var course = courseService.findById(courseSubjectDTO.courseId());
        var subject = subjectService.findById(courseSubjectDTO.subjectId());

        CourseSubject courseSubject = new CourseSubject();
        courseSubject.setCourse(course);
        courseSubject.setSubject(subject);
        courseSubject.setSemester(courseSubjectDTO.semester());

        var courseSubjectKey = new CourseSubjectKey();
        courseSubjectKey.setCourseId(courseSubjectDTO.subjectId());
        courseSubjectKey.setSubjectId(courseSubjectDTO.subjectId());

        courseSubject.setId(courseSubjectKey);

        courseSubjectRepository.save(courseSubject);
    }

    public List<CourseSubjectViewDTO>getAll(){
       List<CourseSubject>courseSubjectList = courseSubjectRepository.findAll();
       return courseSubjectList.stream()
               .map(it-> new CourseSubjectViewDTO(it))
               .collect(Collectors.toList());
    }

    public CourseSubjectViewDTO getById(CourseSubjectKey courseSubjectKey){
        return new CourseSubjectViewDTO(courseSubjectRepository.findById(courseSubjectKey).orElseThrow());

    }



}
