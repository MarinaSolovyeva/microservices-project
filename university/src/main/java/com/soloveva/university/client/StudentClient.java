package com.soloveva.university.client;

import com.soloveva.university.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

    @GetMapping("/university/{university-id}")
    List<Student> findAllStudentsByUniversities(@PathVariable("university-id") Integer schoolId);
}
