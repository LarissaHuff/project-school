package com.projectschool.repository;

import com.projectschool.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course>findAllByNameContainingIgnoreCase(String name);
}
