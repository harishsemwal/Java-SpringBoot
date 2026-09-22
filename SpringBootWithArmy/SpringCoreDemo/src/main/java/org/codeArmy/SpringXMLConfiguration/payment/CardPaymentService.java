package org.codeArmy.SpringXMLConfiguration.payment;

public class CardPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Card Payment Service");
    }
}
