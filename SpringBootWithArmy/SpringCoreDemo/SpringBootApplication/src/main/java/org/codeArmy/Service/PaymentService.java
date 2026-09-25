package org.codeArmy.Service;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public PaymentService() {
        System.out.println("Payment Service Created");
    }

    public void pay() {
        System.out.println("Payment Done");
    }
}
