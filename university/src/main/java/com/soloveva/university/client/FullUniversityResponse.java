package com.soloveva.university.client;

import com.soloveva.university.client.Student;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullUniversityResponse {

    private String name;
    private String email;
    List<Student> students;
}
