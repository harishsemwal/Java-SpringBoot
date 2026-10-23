package org.codeArmy.service;

import org.codeArmy.dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(StudentDto studentDto) {
        System.out.println("Student Created");
        System.out.println(studentDto.getName() + " " + studentDto.getEmail());
        try {
//            Thread.sleep(3000);
        }catch (Exception _){
            System.out.println("exception");
        }
    }
}
