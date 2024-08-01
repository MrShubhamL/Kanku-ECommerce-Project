package com.kanku.controller;

import com.kanku.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;



}