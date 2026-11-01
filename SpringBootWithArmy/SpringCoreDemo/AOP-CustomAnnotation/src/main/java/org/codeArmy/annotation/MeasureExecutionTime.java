package org.codeArmy.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MeasureExecutionTime {
    long warnAfter() default 2000;

    String operation() default "";
}
