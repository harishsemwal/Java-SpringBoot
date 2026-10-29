package org.codeArmy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.codeArmy.entity.Student;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(* org.codeArmy.service.StudentService.createStudent(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {

        Object[] arr = joinPoint.getArgs();
        System.out.println("Student is going to be saved....");
    }

    @After("execution(* org.codeArmy.service.StudentService.createStudent(..))")
    public void logAfterMethod() {
        System.out.println("Student saved is going stop....");
    }

    @AfterReturning(value = "execution(* org.codeArmy.service.StudentService.createStudent(org.codeArmy.entity.Student))", returning = "result")
    public void logAfterReturningMethod(Student result) {
        System.out.println("Student saved AfterReturning...." + result.getAge());
    }

    @AfterThrowing("execution(* org.codeArmy.service.StudentService.createStudent(org.codeArmy.entity.Student))")
    public void logAfterThrowingMethod() {
        System.out.println("Student saved AfterThrowing....");
    }

    @AfterThrowing(value = "execution(* org.codeArmy.service.StudentService.createStudent(org.codeArmy.entity.Student))", throwing = "exception")
    public void logAfterThrowingMethod2(Throwable throwable) {
        System.out.println("Student saved AfterThrowing...." + throwable.getClass().getName());
    }

    @Around(value = "execution(* org.codeArmy.service.StudentService.createStudent(..))")
    public Student logAroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Before Target Method");
        Student student = (Student) proceedingJoinPoint.proceed();
        System.out.println("After Target Method");

        student.setAge(String.valueOf(22));
        return student;
    }


}
