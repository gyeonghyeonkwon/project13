package com.ll.project_13_backend.orders.service;

import com.ll.project_13_backend.cart.entity.Cart;
import com.ll.project_13_backend.cart.service.CartService;
import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.member.service.MemberService;
import com.ll.project_13_backend.orders.entity.Orders;
import com.ll.project_13_backend.orders.repository.OrdersRepository;
import com.ll.project_13_backend.payment.entity.CashLog;
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
        private final MemberService memberService;

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

    public void payByCashOnly(Orders orders) {

        Member buyer = orders.getBuyer(); // 구매자
        long restCash = buyer.getRestCash(); //구매자 가 현재 가지고 있는 캐쉬
        long payPrice = orders.calcPayPrice(); // 총 주문 금액

        if (payPrice > restCash) { //  구매자 가지고있는 캐쉬 가 주문할 금액 이 적을 경 우
            throw new RuntimeException("잔액이 부족합니다");
        }

        memberService.addCash(buyer , payPrice  * -1 , CashLog.EvenType.사용__예치금_주문결제 , orders);

        payDone(orders);
   }
    //결제일
    private void payDone(Orders orders) {
    orders.setPaymentDone();
   }
}
