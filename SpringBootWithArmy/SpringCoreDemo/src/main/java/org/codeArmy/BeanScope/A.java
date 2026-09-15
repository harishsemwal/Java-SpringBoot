package org.codeArmy.BeanScope;

import org.springframework.stereotype.Component;

@Component
public class A {

    private OrderService orderService;

    public void A(OrderService orderService){
        this.orderService = orderService;
    }
}
