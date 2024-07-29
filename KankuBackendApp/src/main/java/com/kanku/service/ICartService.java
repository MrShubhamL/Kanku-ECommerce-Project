package com.kanku.service;

import com.kanku.model.Cart;

public interface ICartService {

    Cart addToCart(Cart cart);
    String deleteCartById(Long cartId);
}
