package org.codeArmy.CircularDependency.simple;

public class A {
    private B b;

    public A() {
        System.out.println("B Created");
        this.b = new B();
    }
}
