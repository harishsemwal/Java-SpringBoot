package org.codeArmy.CircularDependency.simple;

public class B {
    private A a;

    public void setA(A a) {
        System.out.println("A Created");
        this.a = new A();
    }

}
