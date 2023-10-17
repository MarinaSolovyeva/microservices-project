package com.soloveva.university.controllers;

import com.soloveva.university.client.FullUniversityResponse;
import com.soloveva.university.models.University;
import com.soloveva.university.services.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/universities")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody University university
    ) {
        service.saveUniversity(university);
    }

    @GetMapping
    public ResponseEntity<List<University>> findAllUniversities() {
        return ResponseEntity.ok(service.findAllUniversities());
    }

    @GetMapping("/with-students/{university-id}")
    public ResponseEntity<FullUniversityResponse> findAllUniversities(
            @PathVariable("university-id") Integer schoolId
    ) {
        return ResponseEntity.ok(service.findUniversitiesWithStudents(schoolId));
    }
}
