package com.projectschool.repository;

import com.projectschool.model.CourseSubject;
import com.projectschool.model.CourseSubjectKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSubjectRepository extends JpaRepository<CourseSubject, CourseSubjectKey> {
}
