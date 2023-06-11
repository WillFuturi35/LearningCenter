package com.acme.learningcenter.learning.resource;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentResource {

    @NotBlank
    @NotNull
    @Size(max = 100)
    private String name;

    @Min(18)
    private int age;

    @Size(max = 240)
    private String address;
}
