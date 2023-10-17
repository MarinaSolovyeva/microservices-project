package com.soloveva.university.services;

import com.soloveva.university.client.FullUniversityResponse;
import com.soloveva.university.models.University;
import com.soloveva.university.client.StudentClient;
import com.soloveva.university.repositories.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final UniversityRepository repository;
    private final StudentClient client;

    public void saveUniversity(University university) {
        repository.save(university);
    }

    public List<University> findAllUniversities() {
        return repository.findAll();
    }

    public FullUniversityResponse findUniversitiesWithStudents(Integer schoolId) {
        var university = repository.findById(schoolId)
                .orElse(
                        University.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var students = client.findAllStudentsByUniversities(schoolId);
        return FullUniversityResponse.builder()
                .name(university.getName())
                .email(university.getEmail())
                .students(students)
                .build();
    }
}
