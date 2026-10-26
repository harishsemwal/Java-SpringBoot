package org.codeArmy.service.Impl;

import org.codeArmy.Utils.LoggingServiceUtil;
import org.codeArmy.dto.Student;
import org.codeArmy.repository.StudentRepository;
import org.codeArmy.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }
}
