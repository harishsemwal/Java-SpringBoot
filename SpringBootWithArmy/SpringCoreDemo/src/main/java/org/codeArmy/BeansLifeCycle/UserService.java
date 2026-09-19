package org.codeArmy.BeansLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component()
public class UserService implements BeanNameAware, ApplicationContextAware {
    public UserService() {
//        System.out.println("User Service Constructor called....");
    }

    @Override
    public void setBeanName(String name) {
//        System.out.println("Bean name is name: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println("Application Context: " + applicationContext.getClass());
    }
}
