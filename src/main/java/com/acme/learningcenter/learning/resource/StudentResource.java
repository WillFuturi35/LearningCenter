package com.acme.learningcenter.learning.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResource {
    private Long id;
    private String name;
    private String address;
    private int age;
}
