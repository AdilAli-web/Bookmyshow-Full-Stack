package com.cfs.SpringBootP04.controller;

import com.cfs.SpringBootP04.service.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cfs")
public class PaymentController {

    @Value("${app.institute.name}")
    private String instituteName;

    private final PaymentService paymentService;

    public PaymentController(@Qualifier("upiPaymentService") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

   /* public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }*/


    @GetMapping("/pay")
    public String pay()
    {
        System.out.println(instituteName);
        return paymentService.pay();
    }
}
