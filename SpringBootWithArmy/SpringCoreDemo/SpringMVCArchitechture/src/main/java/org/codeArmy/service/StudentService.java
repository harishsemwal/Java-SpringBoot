package org.codeArmy.service;

import org.codeArmy.entity.Student;
import org.codeArmy.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }
}
