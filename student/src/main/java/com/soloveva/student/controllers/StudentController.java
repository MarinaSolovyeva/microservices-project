package com.soloveva.student.controllers;

import com.soloveva.student.models.Student;
import com.soloveva.student.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student) {
        service.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(service.findAllStudents());
    }

    @GetMapping("/university/{university-id}")
    public ResponseEntity<List<Student>> findAllStudents(
            @PathVariable("university-id") Integer universityId
    ) {
        return ResponseEntity.ok(service.findAllStudentsByUniversity(universityId));
    }
}
