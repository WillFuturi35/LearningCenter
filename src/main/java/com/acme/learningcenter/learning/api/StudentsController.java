package com.acme.learningcenter.learning.api;

import com.acme.learningcenter.learning.domain.model.entity.Student;
import com.acme.learningcenter.learning.domain.service.StudentService;
import com.acme.learningcenter.learning.mapping.StudentMapper;
import com.acme.learningcenter.learning.resource.CreateStudentResource;
import com.acme.learningcenter.learning.resource.StudentResource;
import com.acme.learningcenter.learning.resource.UpdateStudentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StudentsController {
    private final StudentService studentService;
    private final StudentMapper mapper;


    public StudentsController(StudentService studentService, StudentMapper mapper) {
        this.studentService = studentService;
        this.mapper = mapper;
    }

    public Page<StudentResource> getAllStudents(Pageable pageable){
        return mapper.modelListPage(studentService.getAll(), pageable);
    }

    public StudentResource getStudentById(Long studentId){
        return mapper.toResource(studentService.getById(studentId));
    }

    public StudentResource updateStudent(Long studentId, UpdateStudentResource resource){
        return mapper.toResource(studentService.update(studentId, mapper.toModel(resource)));
    }

    public ResponseEntity<StudentResource> createStudent(CreateStudentResource resource){
        return new ResponseEntity<>(mapper.toResource(studentService.create(mapper.toModel(resource))),
                HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteStudent(Long studentId){
        return studentService.delete(studentId);
    }
}
