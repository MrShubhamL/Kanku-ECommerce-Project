package com.kanku.controller;

import com.kanku.model.Customer;
import com.kanku.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;



}
