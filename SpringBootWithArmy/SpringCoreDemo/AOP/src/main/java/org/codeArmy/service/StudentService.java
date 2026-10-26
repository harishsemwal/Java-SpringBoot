package org.codeArmy.service;

import org.codeArmy.dto.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    void createStudent(Student student);
}
