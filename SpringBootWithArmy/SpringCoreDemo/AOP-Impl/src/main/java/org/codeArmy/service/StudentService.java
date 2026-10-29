package org.codeArmy.service;

import org.codeArmy.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student createStudent(Student student) {
        System.out.println("create student service called..");
        System.out.println("Student Saved");
        return student;
//        boolean allowed = false;

//        if(!allowed){
//            throw new RuntimeException();
//        }
//        return "Student Saved..";
    }
}
