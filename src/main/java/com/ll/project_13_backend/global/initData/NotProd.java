package com.ll.project_13_backend.global.initData;

import com.ll.project_13_backend.cart.service.CartService;
import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.member.service.MemberService;
import com.ll.project_13_backend.orders.entity.Orders;
import com.ll.project_13_backend.orders.service.OrdersService;
import com.ll.project_13_backend.payment.entity.CashLog;
import com.ll.project_13_backend.post.entity.Category;
import com.ll.project_13_backend.post.entity.Post;
import com.ll.project_13_backend.post.service.PostService;
import com.ll.project_13_backend.product.entity.Product;
import com.ll.project_13_backend.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class NotProd {
    @Autowired
    @Lazy
    private NotProd self;
    private  final MemberService memberService;
    private final PostService postService;
    private final ProductService productService;
    private final CartService cartService;
    private final OrdersService ordersService;


    @Bean
    public ApplicationRunner initNotProd(){
        return args -> {
        self.work1();

        };

    }
    @Transactional
    //회원 가입
    public void work1() {
        if (memberService.findByUsername("admin").isPresent()) return;

        Member user1 =  memberService.join("member2", "111").getData();
        Member user2 =  memberService.join("member3", "111").getData();



        Post post1 = postService.createPost(user1 ,"수업제목1" , "수업내용1" , Category.ENG , 10_000);
        Post post2 = postService.createPost(user2 ,"수업제목2" , "수업내용2" , Category.ENG , 20_000);

        //상품 (수업)
        Product product1 = productService.createProduct(post1);
        Product product2 = productService.createProduct(post2);

        //장바 구니
        cartService.addItem(user1 , product1);
        cartService.addItem(user1 , product2);

        memberService.addCash(user1 ,50000 , CashLog.EvenType.충전__무통장입금 , user1);
        memberService.addCash(user1, -2000, CashLog.EvenType.출금__통장입금, user1);

        Orders order1 = ordersService.createFromCart(user1); //주문

        long orderPayPrice = order1.calcPayPrice();

        ordersService.payByCashOnly(order1);

    }

}
