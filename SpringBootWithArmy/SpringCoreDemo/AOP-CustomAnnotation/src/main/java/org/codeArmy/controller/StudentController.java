package org.codeArmy.controller;

import org.codeArmy.dto.StudentDTO;
import org.codeArmy.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO studentDTO1 = studentService.createStudent(studentDTO);
        return ResponseEntity.ok(studentDTO1);
    }

    @GetMapping
    public ResponseEntity<String> getStudents() {
        studentService.getStudentsWithExecutionTime();
        return ResponseEntity.ok("Student Details");
    }

}
