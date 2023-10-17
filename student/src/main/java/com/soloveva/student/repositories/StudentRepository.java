package com.soloveva.student.repositories;

import com.soloveva.student.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByUniversityId(Integer schoolId);
}
