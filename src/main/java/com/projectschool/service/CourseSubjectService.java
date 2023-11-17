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
    private CourseSubjectRepository courseSubjectRepository;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SubjectService subjectService;

    public void create(CourseSubjectDTO courseSubjectDTO) {
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

    public List<CourseSubject> findAll() {
        return courseSubjectRepository.findAll();
    }

    public CourseSubject findById(CourseSubjectKey courseSubjectKey) {
        return courseSubjectRepository.findById(courseSubjectKey).orElseThrow();

    }


    public List<CourseSubject> findAllSubjectsByCourse(String acronym, String semester) {
        CourseSubject courseSubject = new CourseSubject();
        Course course = courseService.findByAcronym(acronym);
        courseSubject.setSemester(semester);

        return courseSubjectRepository.findAllByCourseId(course.getId());

    }

    public void deleteById(CourseSubjectKey courseSubjectKey) {
        Long courseId = courseSubjectKey.getCourseId();
        courseSubjectKey.setCourseId(courseId);

        Long subjectId = courseSubjectKey.getSubjectId();
        courseSubjectKey.setSubjectId(subjectId);

        courseSubjectRepository.deleteById(courseSubjectKey);
    }

}
