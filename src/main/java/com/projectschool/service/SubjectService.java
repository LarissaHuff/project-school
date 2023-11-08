package com.projectschool.service;

import com.projectschool.dto.SubjectDTO;
import com.projectschool.model.Subject;
import com.projectschool.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> findAllByName(String name) {
        if (name == null) {
            return subjectRepository.findAll();
        }
        return subjectRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Subject findById(Long id) {
        return subjectRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }

    public void register(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setName(subjectDTO.name());
        subject.setDescription(subjectDTO.description());
        subjectRepository.save(subject);
    }

    public void updateSubject(Long id, SubjectDTO subjectDTO){
        Subject subject = findById(id);
        subject.setName(subjectDTO.name());
        subject.setDescription(subjectDTO.description());

        subjectRepository.save(subject);
    }
}
