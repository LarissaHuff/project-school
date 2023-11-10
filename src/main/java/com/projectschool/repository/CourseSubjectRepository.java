package com.projectschool.repository;

import com.projectschool.model.CourseSubject;
import com.projectschool.model.CourseSubjectKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSubjectRepository extends JpaRepository<CourseSubject, CourseSubjectKey> {
    List<CourseSubject>findAllByCourseId(Long courseId);
}
