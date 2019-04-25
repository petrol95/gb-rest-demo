package com.geekbrains.gbrestdemo.controllers;

import com.geekbrains.gbrestdemo.entities.Student;
import com.geekbrains.gbrestdemo.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/api")
@RestController
public class StudentsRestController {
    private StudentsService studentsService;

    @Autowired
    public void setStudentsService(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentsService.getStudentById(studentId);
    }

}
