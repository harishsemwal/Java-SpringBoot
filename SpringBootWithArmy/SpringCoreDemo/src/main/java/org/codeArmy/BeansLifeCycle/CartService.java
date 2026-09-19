package org.codeArmy.BeansLifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Lazy
@Scope("prototype")
public class CartService  implements InitializingBean, DisposableBean {

    Map<Integer, String> mp;


    public CartService() {
        mp = new HashMap<>();
        System.out.println("CartService Constructor....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialization callback InitializingBean");
        mp.put(1, "Harish");
        mp.put(2, "Rohit");
    }

    public void start() {
        System.out.println("Initialization callback Init");
        mp.put(1, "Harish");
        mp.put(2, "Rohit");
    }

    @PostConstruct
    public void startWithPostConstruct(){
        System.out.println("Initialization callback Post Construct");
        mp.put(1, "Hanuman");
        mp.put(2, "Rohit");
    }

    @Override
    public void destroy() throws Exception {
        mp.clear();
        System.out.println("Bean is getting destroyed....");
    }

    public void stop(){
        mp.clear();
        System.out.println("destruction callback : through Init Method");
    }

    @PreDestroy
    public void endWithPreDestroy(){
        mp.clear();
        System.out.println("Destroying callback endWithPreDestroy");
    }

    public String getValue(int key){
        return mp.get(key);
    }

    public void addToCart() {
        System.out.println("Added to cart....");
    }
}
