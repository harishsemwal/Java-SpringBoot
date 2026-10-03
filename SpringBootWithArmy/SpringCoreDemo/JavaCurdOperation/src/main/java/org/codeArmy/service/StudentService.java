package org.codeArmy.service;

import org.codeArmy.entity.StudentEntity;
import org.codeArmy.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity createStudent(StudentEntity studentEntity) {
        StudentEntity createStudent = studentRepository.save(studentEntity);
        return createStudent;
    }

    public StudentEntity getStudentById(Long id){
        Optional<StudentEntity> studentById = studentRepository.findById(id);
        if(studentById.isPresent()){
            return studentById.get();
        }
        return new StudentEntity();
    }

    public List<StudentEntity> getAllStudents(){
        List<StudentEntity> students = studentRepository.findAll();
        return students;
    }

    public StudentEntity updateStudent(Long id, StudentEntity student){
        Optional<StudentEntity> exitingStudentEntity = studentRepository.findById(id);
        if(!exitingStudentEntity.isPresent()){
            return null;
        }
        StudentEntity newStudentEntity = exitingStudentEntity.get();
        newStudentEntity.setName(student.getName());
        newStudentEntity.setAge(student.getAge());
        newStudentEntity.setRollNo(student.getRollNo());
        newStudentEntity.setEmail(student.getEmail());
        newStudentEntity.setSubject(student.getSubject());

        return newStudentEntity;
    }

    public boolean deleteStudent(Long id){
        studentRepository.deleteById(id);
        Boolean isStudentPresent = studentRepository.existsById(id);
        if(isStudentPresent){
            return false;
        }
        return true;
    }



    // End Point Store(/api/student/) : POST

    // Business logic

    // Interact with DB

    // Response back to client (Postman)
}
