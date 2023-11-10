package com.projectschool.dto;

import com.projectschool.model.CourseSubject;

public record CourseSubjectViewDTO(Long subjectId, Long courseId, String semester) {
    public CourseSubjectViewDTO(CourseSubject courseSubject) {
        this(courseSubject.getId().getSubjectId(), courseSubject.getId().getCourseId(), courseSubject.getSemester());
    }
}
