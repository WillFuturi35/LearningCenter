package com.acme.learningcenter.learning.resource;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentResource {

    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 60)
    private String name;

    @Min(18)
    private int age;

    @Size(max = 240)
    private String address;
}
