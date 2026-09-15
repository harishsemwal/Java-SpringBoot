package org.codeArmy.BeanScope;

import org.springframework.stereotype.Component;

@Component
public class B {

    private OrderService orderService;

    public void B(OrderService orderService){
        this.orderService = orderService;
    }
}
