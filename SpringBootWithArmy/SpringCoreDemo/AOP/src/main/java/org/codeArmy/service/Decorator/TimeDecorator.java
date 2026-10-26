package org.codeArmy.service.Decorator;

import org.codeArmy.dto.Student;
import org.codeArmy.service.StudentService;
import org.springframework.stereotype.Component;

@Component
public class TimeDecorator implements StudentService {
    @Override
    public void createStudent(Student student) {

    }
}
