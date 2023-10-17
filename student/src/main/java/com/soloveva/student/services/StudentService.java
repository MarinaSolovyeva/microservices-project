package com.soloveva.student.services;

import com.soloveva.student.models.Student;
import com.soloveva.student.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void saveStudent(Student student) {
        repository.save(student);
    }

    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    public List<Student> findAllStudentsByUniversity(Integer universityId) {
        return repository.findAllByUniversityId(universityId);
    }
}
