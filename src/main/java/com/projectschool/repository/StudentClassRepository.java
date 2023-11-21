package com.projectschool.repository;

import com.projectschool.model.StudentClass;
import com.projectschool.model.StudentClassKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, StudentClassKey> {
    List<StudentClass> findAllByStudentId(Long studentId);
}
