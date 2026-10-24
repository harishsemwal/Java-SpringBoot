package org.codeArmy.service;

import org.codeArmy.dto.StudentDto;
import org.codeArmy.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public StudentResponseDto createStudent(StudentDto studentDto) {

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setName(studentDto.getName());
        studentResponseDto.setMessage("Student is saved successfully");

        return studentResponseDto;

//        System.out.println("Student Created");
//        System.out.println(studentDto.getName() + " " + studentDto.getEmail());
//        try {
//            Thread.sleep(3000);
//        } catch (Exception _) {
//            System.out.println("exception");
//        }
    }
}
