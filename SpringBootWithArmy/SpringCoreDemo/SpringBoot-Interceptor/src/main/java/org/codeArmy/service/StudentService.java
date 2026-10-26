package org.codeArmy.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public String createStudent() {
        System.out.println("Student Service called.. Student Created..");
        return "student created";
    }
}
