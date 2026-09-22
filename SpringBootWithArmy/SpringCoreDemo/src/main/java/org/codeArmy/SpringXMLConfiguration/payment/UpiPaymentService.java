package org.codeArmy.SpringXMLConfiguration.payment;

public class UpiPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("UPI Payment Service");
    }
}
