package org.codeArmy.service;

import org.codeArmy.entity.Student;

public interface StudentServiceInterface {

    public Student createStudent(Student student);

    public String getStudents(String str);
}
