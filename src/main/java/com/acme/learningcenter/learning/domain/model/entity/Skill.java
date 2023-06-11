package com.acme.learningcenter.learning.domain.model.entity;

import com.acme.learningcenter.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

//Inicio de anotaciones de lombok

@Getter
@Setter
@With
//Fin de anotaciones de lombok
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "skills")
public class Skill extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;



}
