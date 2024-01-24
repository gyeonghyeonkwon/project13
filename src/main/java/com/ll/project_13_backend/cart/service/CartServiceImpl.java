package com.ll.project_13_backend.cart.service;

import com.ll.project_13_backend.cart.entity.Cart;
import com.ll.project_13_backend.cart.repository.CartRepository;
import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 장바구니 구현
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    @Transactional
    public Cart addItem(Member buyer , Product product) {
        //상품을  cart 에 저장한다 .
        Cart cart = Cart.builder()
                .buyer(buyer)
                .product(product)
                .build();
        cartRepository.save(cart);

        return cart;
    }
    // 구매자를 찾는다
    public List<Cart> findItemsByBuyer(Member buyer) {
        return cartRepository.findByBuyer(buyer);
    }

    public void delete(Cart cart) {
        cartRepository.delete(cart);
    }
}
