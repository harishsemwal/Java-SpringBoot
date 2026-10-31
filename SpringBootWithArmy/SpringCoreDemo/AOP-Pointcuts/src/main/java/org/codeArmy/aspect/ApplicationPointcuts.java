package org.codeArmy.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcuts {

    @Pointcut("within(org.codeArmy.controller..*)")
    public void controllerLayer(){

    }

    @Pointcut("within(org.codeArmy.controller..*)")
    public void ServiceLayer(){

    }

    @Pointcut("execution(public * * (..)")
    public void publicMethodPointcuts(){

    }

    @Pointcut("ServiceLayer() && publicMethodPointcuts()")
    public void publicMethodPointcutsService(){

    }
}
