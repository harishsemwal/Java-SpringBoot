package org.codeArmy.controller;

import org.codeArmy.entity.Student;
import org.codeArmy.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student studentResponse = studentService.createStudent(student);
        return ResponseEntity.ok(studentResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id){
        Student studentResponse = studentService.getStudent(id);
        return ResponseEntity.ok(studentResponse);
    }

    @GetMapping
    public List<Student> getAllStudent() {
        List<Student> studentResponse = studentService.getAllStudent();
        return ResponseEntity.ok(studentResponse).getBody();
    }
}
