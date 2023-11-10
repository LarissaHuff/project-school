package com.projectschool.dto;

import com.projectschool.model.CourseSubject;

public record SubjectByCourseViewDTO(Long subjectId, String subjectName, String semester) {
    public SubjectByCourseViewDTO(CourseSubject courseSubject){
        this(courseSubject.getId().getSubjectId(), courseSubject.getSubject().getName(), courseSubject.getSemester());
    }
}
