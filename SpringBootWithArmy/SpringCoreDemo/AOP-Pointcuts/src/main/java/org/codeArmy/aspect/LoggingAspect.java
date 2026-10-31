package org.codeArmy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.codeArmy.entity.Student;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    /*
    @Before("execution(String org.codeArmy.service.StudentService.getStudents(String))")
    public void logBeforeMethod() {
        System.out.println("Method Intercepted....");
    }

    //    @Before("execution(* * (*))")
    public void logBeforeAnotherMethod() {
        System.out.println("Method Intercepted Another....");
    }

    @Before("execution(org.codeArmy.entity.Student org.codeArmy.service.StudentService.createStudent(org.codeArmy.entity.Student))")
    public void logAfterMethod() {
        System.out.println("Method Intercepted....");
    }

    @Before("within(org.codeArmy.service..*)")
    public void logBeforeMethodLevel() {
        System.out.println("Method Intercepted Within....");
    }

    @Before("@annotation(java.beans.Transient)")
    public void logBeforeMethodAnnotation() {
        System.out.println("Method Intercepted Annotation....");
    }

    @Before("bean(studentService)")
    public void logBeforeMethodBean() {
        System.out.println("Method Intercepted logBeforeMethodBean.....");
    }

    @Before("bean(studentService) || bean(studentController)")
    public void logBeforeMethodBeanOperator() {
        System.out.println("Method Intercepted logBeforeMethodBeanOperator.....");
    }

    @Pointcut("execution(public * *(..)" + "&&" + "within(org.codeArmy.service..*)")
    public void logPublicServiceMethod() {

    }

    @Before("logPublicServiceMethod()")
    public void logBeforeMethodLevelAndMethod() {
        System.out.println("Method Intercepted logBeforeMethodLevelAndMethod....");
    }

    @Pointcut("org.codeArmy.aspect.ApplicationPointcuts.publicMethodPointcutsService()")
    public void UsingGenericPointcuts() {
        System.out.println("Method Intercepted UsingGenericPointcuts....");
    }

    @Before("@within(org.springframework.stereotype.Service)")
    public void usingAnnotationBasedService() {
        System.out.println("Method Intercepted UsingAnnotationBasedService....");
    }


    @Before("@target(org.springframework.stereotype.Service)")
    public void usingAnnotationBasedServiceTarget() {
        System.out.println("Method Intercepted usingAnnotationBasedServiceTarget....");
    }
     */

    @Before("target(org.codeArmy.service.StudentService)")
    public void getUnderstandTargetMethod() {
        System.out.println("Method Intercepted getUnderstandTargetMethod....");
    }

    @Before("this(org.codeArmy.service.StudentServiceInterface)")
    public void getUnderstandThisMethod() {
        System.out.println("Method Intercepted getUnderstandThisMethod....");
    }

}
