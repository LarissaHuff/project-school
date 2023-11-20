package com.projectschool.dto;

import com.projectschool.model.CourseSubject;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CourseSubjectDTO(Long subjectId, Long courseId, @NotBlank @Min(1) String semester) {
    public CourseSubjectDTO (CourseSubject courseSubject){
        this(courseSubject.getId().getSubjectId(), courseSubject.getId().getCourseId(), courseSubject.getSemester());
    }

}
