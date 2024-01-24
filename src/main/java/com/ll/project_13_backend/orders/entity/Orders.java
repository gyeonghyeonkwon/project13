package com.ll.project_13_backend.orders.entity;

import com.ll.project_13_backend.cart.entity.Cart;
import com.ll.project_13_backend.global.BaseEntity;
import com.ll.project_13_backend.member.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Setter
@Getter
@ToString(callSuper = true)
public class Orders extends BaseEntity {

    @ManyToOne(fetch = LAZY) //지연 로딩
    private Member buyer; //구매자 (학생)

    private boolean isPaid ; //구매 여부
    private boolean isCanceled ; // 취소 여부
    private boolean isRefund ; // 환불 여부

    @Builder.Default
    @OneToMany(mappedBy = "orders", cascade = ALL, orphanRemoval = true)

    private List<OrdersItem> ordersItems = new ArrayList<>();


    // 상품을 주문 할때 장바구니에 저장된 여러 상품을 불러온다.
    public void addItem(Cart cart) {
        OrdersItem ordersItem = OrdersItem.builder()
                .orders(this)
                .product(cart.getProduct())
                .build();

        ordersItems.add(ordersItem);
    }

}
