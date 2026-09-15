package org.codeArmy.BeanScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
//@Scope("prototype")
public class OrderService {

    public OrderService(){
        System.out.println("Order Constructor..");
    }
    public void placeOrder(){
        System.out.println("Order Placed...");
    }
}
