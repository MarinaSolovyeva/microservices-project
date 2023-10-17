package com.soloveva.university.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class University {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
}
