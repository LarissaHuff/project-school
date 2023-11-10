package com.projectschool.service;

import com.projectschool.dto.CourseSubjectViewDTO;
import com.projectschool.dto.SubjectByCourseViewDTO;
import com.projectschool.model.Course;
import com.projectschool.model.CourseSubject;
import com.projectschool.dto.CourseSubjectDTO;
import com.projectschool.model.CourseSubjectKey;
import com.projectschool.repository.CourseSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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

    public void register(CourseSubjectDTO courseSubjectDTO) {
        var course = courseService.findById(courseSubjectDTO.courseId());
        var subject = subjectService.findById(courseSubjectDTO.subjectId());

        CourseSubject courseSubject = new CourseSubject();
        courseSubject.setCourse(course);
        courseSubject.setSubject(subject);
        courseSubject.setSemester(courseSubjectDTO.semester());

        var courseSubjectKey = new CourseSubjectKey();
        courseSubjectKey.setCourseId(courseSubjectDTO.courseId());
        courseSubjectKey.setSubjectId(courseSubjectDTO.subjectId());

        courseSubject.setId(courseSubjectKey);

        courseSubjectRepository.save(courseSubject);
    }

    public List<CourseSubjectViewDTO> getAll() {
        List<CourseSubject> courseSubjectList = courseSubjectRepository.findAll();
        return courseSubjectList.stream()
                .map(it -> new CourseSubjectViewDTO(it))
                .collect(Collectors.toList());
    }

    public CourseSubjectViewDTO getById(CourseSubjectKey courseSubjectKey) {
        return new CourseSubjectViewDTO(courseSubjectRepository.findById(courseSubjectKey).orElseThrow());

    }


    public List<SubjectByCourseViewDTO> getAllSubjectsByCourse(String acronym, String semester) {
        Course course = courseService.findByAcronym(acronym);
        List<CourseSubject> courseSubject = courseSubjectRepository.findAllByCourseId(course.getId());


        return courseSubject.stream()
                .map(SubjectByCourseViewDTO::new)
                .sorted(Comparator.comparing(SubjectByCourseViewDTO::semester))
                .filter(it -> semester == null || it.semester().equals(semester))
                .collect(Collectors.toList());
    }

}
