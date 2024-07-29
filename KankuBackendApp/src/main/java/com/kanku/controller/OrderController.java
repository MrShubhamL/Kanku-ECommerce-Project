package com.kanku.controller;

import com.kanku.model.Order;
import com.kanku.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/orderProduct")
    public ResponseEntity orderProduct(@RequestBody Order order){
        return ResponseEntity.ok(orderService.orderProduct(order));
    }
}
