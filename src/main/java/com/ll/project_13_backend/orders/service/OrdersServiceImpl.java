package com.ll.project_13_backend.orders.service;

import com.ll.project_13_backend.cart.entity.Cart;
import com.ll.project_13_backend.cart.service.CartService;
import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.orders.entity.Orders;
import com.ll.project_13_backend.orders.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {
        private final CartService cartService;
        private final OrdersRepository ordersRepository;

        //장바구니에 저장되어있는 상품을 주문 에 가지고온다 (주문생성)
   public  Orders createFromCart(Member buyer){

       List<Cart> cartItem = cartService.findItemsByBuyer(buyer); //구매자 가 장바구니 의 상품을 가지고 온다.
       
       Orders orders = Orders.builder()
               .buyer(buyer)
               .build();

       cartItem
               .stream()
               .forEach(orders::addItem);
       ordersRepository.save(orders);  //주문 생성

       cartItem.stream()
               .forEach(cartService::delete); //주문이 완료 되면 장바구니에 저장되어있는 상품을 삭제한다.

       return orders;
   }


}
