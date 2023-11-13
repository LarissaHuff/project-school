package com.projectschool.service;

import com.projectschool.model.Teacher;
import com.projectschool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository repository;

    public Teacher findById(Long id){
        return repository.findById(id).orElseThrow();
    }

}
