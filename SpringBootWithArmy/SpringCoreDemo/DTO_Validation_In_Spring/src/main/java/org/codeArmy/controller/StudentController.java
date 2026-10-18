package org.codeArmy.controller;

import jakarta.validation.Valid;
import org.codeArmy.dto.CreateStudentRequestDTO;
import org.codeArmy.dto.CreateStudentResponseDTO;
import org.codeArmy.dto.UpdateStudentRequestDTO;
import org.codeArmy.dto.UpdateStudentResponseDTO;
import org.codeArmy.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    StudentService studentService;

    public  StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //create
    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDTO> createStudent(@Valid @RequestBody CreateStudentRequestDTO studentRequestDTO){
        CreateStudentResponseDTO studentResponse = studentService.createStudent(studentRequestDTO);
        return ResponseEntity.ok(studentResponse);
    }

    @PostMapping("/update")
    public ResponseEntity<UpdateStudentResponseDTO> updateStudent(@RequestBody UpdateStudentRequestDTO updateStudentRequestDTO){
        System.out.println("Id: " +  updateStudentRequestDTO.getId());
        UpdateStudentResponseDTO updateStudentResponseDTO = studentService.updateStudent(updateStudentRequestDTO.getId(), updateStudentRequestDTO);
        return ResponseEntity.ok(updateStudentResponseDTO);
    }

    //read
    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudent(){
        List<CreateStudentResponseDTO> studentList = studentService.getAllStudents();
        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

    //delete
}
