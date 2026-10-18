package org.codeArmy.service;

import org.codeArmy.dto.CreateStudentRequestDTO;
import org.codeArmy.dto.CreateStudentResponseDTO;
import org.codeArmy.dto.UpdateStudentRequestDTO;
import org.codeArmy.dto.UpdateStudentResponseDTO;
import org.codeArmy.entity.Student;
import org.codeArmy.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentRequestDTO){
        Student student = mapToEntity(studentRequestDTO);
        Student studentResponse = studentRepository.save(student);
        CreateStudentResponseDTO studentResponseDTO = entityToDto(studentResponse);
        return studentResponseDTO;
    }

    private Student mapToEntity(CreateStudentRequestDTO studentRequestDTO){
        Student student = new Student();
        student.setId(studentRequestDTO.getId());
        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setCreateAt(LocalDate.now());
        return student;
    }

    private CreateStudentResponseDTO entityToDto(Student student){
        CreateStudentResponseDTO studentResponseDTO = new CreateStudentResponseDTO();
        studentResponseDTO.setId(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setCreatedAt(student.getCreateAt());
        studentResponseDTO.setMessage("Student Created Successfully..");
        return  studentResponseDTO;
    }

    public UpdateStudentResponseDTO updateStudent(Long id, UpdateStudentRequestDTO updateStudentRequestDTO){
        Optional<Student> existStudent = studentRepository.findById(id);

        if(existStudent.isEmpty()){
            return null;
        }
        Student student = existStudent.get();

        student.setId(updateStudentRequestDTO.getId());
        student.setCreateAt(LocalDate.now());
        student.setName(updateStudentRequestDTO.getName());

        studentRepository.save(student);

        UpdateStudentResponseDTO updateStudentResponseDTO = UpdateEntityToDTO(student);
        return updateStudentResponseDTO;
    }

    private UpdateStudentResponseDTO UpdateEntityToDTO(Student student){
        UpdateStudentResponseDTO updateStudentResponseDTO = new UpdateStudentResponseDTO();
        updateStudentResponseDTO.setId(student.getId());
        updateStudentResponseDTO.setName(student.getName());
        updateStudentResponseDTO.setEmail(student.getEmail());
        updateStudentResponseDTO.setCreateAt(student.getCreateAt());
        updateStudentResponseDTO.setMessage("Student Created Successfully..");
        return  updateStudentResponseDTO;
    }

    public List<CreateStudentResponseDTO> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList.stream().map(this::entityToDto).toList();
    }
}
