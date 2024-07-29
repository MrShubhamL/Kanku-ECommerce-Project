package com.kanku.controller;

import com.kanku.model.Cart;
import com.kanku.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {

    @Autowired
    private ICartService cartService;

    @PostMapping("/addToCart")
    public ResponseEntity<?> addToCart(@RequestBody Cart cart){
      return ResponseEntity.ok(cartService.addToCart(cart));
    }

    @DeleteMapping("/deleteCart/{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable("cartId") Long cartId){
        return ResponseEntity.ok(cartService.deleteCartById(cartId));
    }


}
