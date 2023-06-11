package com.acme.learningcenter.learning.domain.model.entity;

import com.acme.learningcenter.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student extends AuditModel {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 100)
    private String name;
    @Size(max = 240)
    private String address;
    private int age;

}
