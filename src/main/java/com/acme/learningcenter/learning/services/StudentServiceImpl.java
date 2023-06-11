package com.acme.learningcenter.learning.services;

import com.acme.learningcenter.learning.domain.model.entity.Student;
import com.acme.learningcenter.learning.domain.persistence.StudentRepository;
import com.acme.learningcenter.learning.domain.service.StudentService;
import com.acme.learningcenter.shared.exception.ResourceNotFoundException;
import com.acme.learningcenter.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Set;

public class StudentServiceImpl implements StudentService {

    private static final String ENTITY = "Student";

    private final StudentRepository studentRepository;

    private final Validator validator;

    public StudentServiceImpl(StudentRepository studentRepository, Validator validator){
        this.studentRepository = studentRepository;
        this.validator = validator;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Long studentId) {
        return studentRepository.findById(studentId).
                orElseThrow(()-> new ResourceNotFoundException(ENTITY,studentId));
    }

    @Override
    public Page<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }


    @Override
    public Student create(Student student) {

        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        //Name Uniqueness validation

        Student studentWithName = studentRepository.findByName(student.getName());

        if( studentWithName != null)
            throw new ResourceValidationException(ENTITY,
                    "An student with the same name already exits.");

        return studentRepository.save(student);
    }

    @Override
    public Student update(Long studentId, Student request) {

        //Violation
        Set<ConstraintViolation<Student>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        //Validation --> Name
        Student studentWithName = studentRepository.findByName(request.getName());
        if (studentWithName != null && !studentWithName.getId().equals(studentId))
            throw new ResourceValidationException(ENTITY,
                    "An student with the same name already exits.");


        return studentRepository.findById(studentId).map(student ->
                studentRepository.save(student.withName(request.getName())
                        .withAge(request.getAge())
                        .withAddress(request.getAddress())))
                        .orElseThrow(() -> new ResourceNotFoundException(ENTITY, studentId));

    }

    @Override
    public ResponseEntity<?> delete(Long studentId) {
        return studentRepository.findById(studentId).map(student -> {
            studentRepository.delete(student);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, studentId));
    }
}












