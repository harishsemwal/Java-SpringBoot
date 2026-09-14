package org.codeArmy.Payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier
public class CardlessPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Card Payment Service Done...");
    }
}
