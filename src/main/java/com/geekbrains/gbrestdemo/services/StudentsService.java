package com.geekbrains.gbrestdemo.services;

import com.geekbrains.gbrestdemo.entities.Student;
import com.geekbrains.gbrestdemo.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {
    private StudentsRepository studentsRepository;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Student getStudentById(Long id) {
        return studentsRepository.findById(id).get();
    }
}
