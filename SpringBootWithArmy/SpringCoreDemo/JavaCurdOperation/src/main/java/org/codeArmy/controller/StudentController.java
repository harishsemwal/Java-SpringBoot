package org.codeArmy.controller;

import org.codeArmy.entity.StudentEntity;
import org.codeArmy.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody StudentEntity studentEntity) {
        StudentEntity createdStudentEntity = studentService.createStudent(studentEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student Details Added");
    }

    // read one student
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable Long id){
        System.out.println("Id: " + id);
        StudentEntity student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentEntity>> getAllStudents(){
        List<StudentEntity> student = studentService.getAllStudents();
        if(student.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Long id, @RequestBody StudentEntity student){
        StudentEntity studentEntity = studentService.updateStudent(id, student);
        return ResponseEntity.ok(studentEntity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        boolean student = studentService.deleteStudent(id);
        if (student){
            return ResponseEntity.ok("Student Record Deleted..");
        }
        return ResponseEntity.ok("Student Record Not Present..");
    }

}
