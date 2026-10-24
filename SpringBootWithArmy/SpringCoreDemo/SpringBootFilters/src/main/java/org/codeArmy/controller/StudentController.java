package org.codeArmy.controller;

import org.codeArmy.dto.StudentDto;
import org.codeArmy.dto.StudentResponseDto;
import org.codeArmy.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentResponseDto studentResponseDto = studentService.createStudent(studentDto);
        return ResponseEntity.ok(studentResponseDto);
    }

}
