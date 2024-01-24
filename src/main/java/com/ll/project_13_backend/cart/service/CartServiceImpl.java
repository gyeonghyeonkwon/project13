package com.ll.project_13_backend.cart.service;

import com.ll.project_13_backend.cart.entity.Cart;
import com.ll.project_13_backend.cart.repository.CartRepository;
import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 장바구니 구현
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    @Transactional
    public Cart addItem(Member member , Product product) {

        Cart cart = Cart.builder()
                .member(member)
                .product(product)
                .build();
        cartRepository.save(cart);

        return cart;
    }
}
