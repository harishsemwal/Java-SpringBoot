package org.codeArmy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@EnableAutoConfiguration
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
//        paymentGateway.setType("Paytm");
//        paymentGateway.setRetryCount(5);
//        paymentGateway.print();

    }
}