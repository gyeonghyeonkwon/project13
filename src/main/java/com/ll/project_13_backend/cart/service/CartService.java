package com.ll.project_13_backend.cart.service;

import com.ll.project_13_backend.cart.entity.Cart;
import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.product.entity.Product;

import java.util.List;

public interface CartService {
    Cart addItem(Member member, Product product1);

    List<Cart> findItemsByBuyer(Member buyer);

    void delete(Cart cart);
}
