package org.codeArmy.controller;

import org.codeArmy.entity.StudentEntity;
import org.codeArmy.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentEntity student) {
        studentRepository.createUser(student);
        return ResponseEntity.ok("Student created successfully");
    }

    // UPDATE
    @PutMapping
    public ResponseEntity<String> updateStudent() {
        studentRepository.updateUser();
        return ResponseEntity.ok("Student updated successfully");
    }

    // DELETE
    @DeleteMapping
    public ResponseEntity<String> deleteStudent() {
        studentRepository.deleteUser();
        return ResponseEntity.ok("Student deleted successfully");
    }

    // READ BY ID
    @GetMapping
    public ResponseEntity<String> getStudentById() {
        studentRepository.getUserById();
        return ResponseEntity.ok("Student fetched successfully");
    }

    @GetMapping("/allStudents")
    public ResponseEntity<String> getStudentByAll() {
        studentRepository.getStudent();
        return ResponseEntity.ok("Student fetched successfully");
    }

    // READ ALL
    @GetMapping("/all")
    public ResponseEntity<String> getAllStudents() {
        studentRepository.completeCURD();
        return ResponseEntity.ok("Students fetched successfully");
    }
}
