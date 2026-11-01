package org.codeArmy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.codeArmy.annotation.MeasureExecutionTime;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import java.awt.*;

@Component
@Aspect
public class SimpleAspect {

    @Before("@annotation(jdk.jfr.Timestamp)")
    public void logBeforeMethod() {
        System.out.println("Method Intercepted....");
    }

    @Around("@annotation(org.codeArmy.annotation.TrackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            return proceedingJoinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long totalDuration = endTime - startTime;

            String methodName = proceedingJoinPoint.getSignature().getName();
            System.out.println("Time Taken by " + methodName + " : " + totalDuration);
        }
    }


    @Around("@annotation(measureExecutionTime)")
    public Object measureExecutionTimeMethod(ProceedingJoinPoint proceedingJoinPoint, MeasureExecutionTime measureExecutionTime) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            return proceedingJoinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long totalDuration = endTime - startTime;

            String operation = measureExecutionTime.operation();

            if (operation.isBlank()) {
                operation = proceedingJoinPoint.getSignature().getName();
            }

            long warningThreshold = measureExecutionTime.warnAfter();

            if (totalDuration >= warningThreshold) {
                System.out.println("Slow Operation !");
            } else {
                System.out.println("Time Taken By " + operation + ": " + totalDuration);
            }

            String methodName = proceedingJoinPoint.getSignature().getName();
            System.out.println("MeasureExecutionTimeMethod: Time Taken by " + methodName + " : " + totalDuration);
        }
    }
}
