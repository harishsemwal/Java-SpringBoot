package org.codeArmy.service;

import jdk.jfr.Timestamp;
import org.codeArmy.annotation.MeasureExecutionTime;
import org.codeArmy.annotation.TrackExecutionTime;
import org.codeArmy.dto.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public StudentDTO createStudent(StudentDTO studentDTO) {
        studentDTO.setFirstName("Harish");
        studentDTO.setLastName("Prasad");
        System.out.println("Student Created..");
        return studentDTO;
    }

    @TrackExecutionTime
    public void getStudents() {
        System.out.println("Student Details Fetched..");

        try {
            Thread.sleep(5000);
        } catch (Exception _) {
            System.out.println("Noting");
        }

    }

    @MeasureExecutionTime(
            warnAfter = 1500,
            operation = "Get Student Data"
    )
    public void getStudentsWithExecutionTime() {
        System.out.println("Student Details Fetched getStudentsWithExecutionTime..");

        try {
            Thread.sleep(5000);
        } catch (Exception _) {
            System.out.println("Noting");
        }

    }
}
