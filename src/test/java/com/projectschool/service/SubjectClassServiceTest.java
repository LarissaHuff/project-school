package com.projectschool.service;

import com.projectschool.exception.NotFoundException;
import com.projectschool.model.SubjectClass;
import com.projectschool.repository.SubjectClassRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class SubjectClassServiceTest {

    private SubjectClassService subjectClassService;

    private SubjectClassRepository repository;


    @BeforeEach
    public void setUp() {
        repository = Mockito.mock(SubjectClassRepository.class);
        subjectClassService = new SubjectClassService(repository, null, null);
    }

    @Test
    void shouldFindSubjectClass() {
        //given the parameters
        SubjectClass subjectClass = new SubjectClass();
        subjectClass.setId(1L);
        subjectClass.setVacancies(20);

        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.of(subjectClass));

        //when
        SubjectClass response = subjectClassService.findById(1L);

        //then
        Assertions.assertEquals(1L, response.getId());
        Assertions.assertEquals(20, response.getVacancies());

        verify(repository).findById(1L);
        verifyNoMoreInteractions(repository);
    }

    @Test
    @DisplayName("should not find subject class and throw an exception")
    void shouldNotFindSubjectClass() {
        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.empty());

        NotFoundException notFoundException = assertThrows(NotFoundException.class,
                () -> subjectClassService.findById(1L));

        Assertions.assertEquals("Subject Class not found.", notFoundException.getMessage());

        verify(repository).findById(1L);
        verifyNoMoreInteractions(repository);
    }
}