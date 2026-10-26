package org.codeArmy.repository;

import org.codeArmy.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository{
    public void save(Student student){
        System.out.println("Student Saved");
    }
}
