package org.codeArmy.CircularDependency.simple;

import jakarta.annotation.PostConstruct;

public class A {
    private B b;

    public A() {
        System.out.println("B Created");
        this.b = new B();
    }

    @PostConstruct
    public void setB(){
        b.setA(this);
    }
}
