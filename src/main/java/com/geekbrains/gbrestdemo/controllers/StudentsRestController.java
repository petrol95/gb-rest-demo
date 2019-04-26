package com.geekbrains.gbrestdemo.controllers;

import com.geekbrains.gbrestdemo.entities.Student;
import com.geekbrains.gbrestdemo.services.StudentsService;
import com.geekbrains.gbrestdemo.utils.StudentNotFoundException;
import com.geekbrains.gbrestdemo.utils.StudentsErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentsService.getAllStudentsList();
    }

    @ExceptionHandler
    public ResponseEntity<StudentsErrorResponse> handleException(StudentNotFoundException exc) {
        StudentsErrorResponse studentsErrorResponse = new StudentsErrorResponse();
        studentsErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentsErrorResponse.setMessage(exc.getMessage());
        studentsErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(studentsErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentsErrorResponse> handleAllException(Exception exc) {
        StudentsErrorResponse studentsErrorResponse = new StudentsErrorResponse();
        studentsErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentsErrorResponse.setMessage(exc.getMessage());
        studentsErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(studentsErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
