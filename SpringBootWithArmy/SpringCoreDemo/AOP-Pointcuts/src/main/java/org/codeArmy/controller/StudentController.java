package org.codeArmy.controller;

import org.codeArmy.entity.Student;
import org.codeArmy.service.StudentService;
import org.codeArmy.service.StudentServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentServiceInterface studentService;

    public StudentController(StudentServiceInterface studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println("Student Created");
        Student response = studentService.createStudent(student);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<String> getStudents(){
        String str = "All Students Data..";
        return ResponseEntity.ok(studentService.getStudents(str));
    }
}
