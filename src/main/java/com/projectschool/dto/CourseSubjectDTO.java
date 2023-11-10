package com.projectschool.model;

public record CourseSubjectDTO(Long subjectId, Long courseId, String semester) {
    public CourseSubjectDTO (CourseSubject courseSubject){
        this(courseSubject.getId().getSubjectId(), courseSubject.getId().getCourseId(), courseSubject.getSemester());
    }

}
