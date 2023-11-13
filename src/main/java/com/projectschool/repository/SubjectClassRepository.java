package com.projectschool.repository;

import com.projectschool.model.SubjectClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectClassRepository extends JpaRepository<SubjectClass, Long> {

}
