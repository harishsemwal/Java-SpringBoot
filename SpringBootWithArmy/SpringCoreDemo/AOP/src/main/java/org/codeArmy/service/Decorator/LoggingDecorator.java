package org.codeArmy.service.Decorator;

import org.codeArmy.Utils.LoggingServiceUtil;
import org.codeArmy.dto.Student;
import org.codeArmy.service.Impl.StudentServiceImpl;
import org.codeArmy.service.StudentService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LoggingDecorator implements StudentService {

    private StudentServiceImpl studentServiceImpl;

    public LoggingDecorator(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public void createStudent(Student student) {
        LoggingServiceUtil.logStart("StudentServiceImpl", "CreateStudent");
        studentServiceImpl.createStudent(student);
        LoggingServiceUtil.logEnds("StudentServiceImpl", "CreateStudent");
    }
}
