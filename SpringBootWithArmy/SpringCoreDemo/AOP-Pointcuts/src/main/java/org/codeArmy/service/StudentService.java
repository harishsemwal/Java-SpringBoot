package org.codeArmy.service;

import org.codeArmy.entity.Student;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class StudentService implements StudentServiceInterface {

//    @Transient
    public Student createStudent(Student student) {
        System.out.println("Student saved...");
        return student;
    }

    
    public String getStudents(String str) {
        System.out.println(str);
        return str;
    }
}
