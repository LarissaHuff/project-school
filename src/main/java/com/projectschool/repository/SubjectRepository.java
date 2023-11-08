package com.projectschool.repository;

import com.projectschool.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject>findAllByNameContainingIgnoreCase(String name);
}
