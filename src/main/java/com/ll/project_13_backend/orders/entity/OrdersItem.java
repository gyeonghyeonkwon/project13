package com.ll.project_13_backend.orders.entity;

import com.ll.project_13_backend.global.BaseEntity;
import com.ll.project_13_backend.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@AllArgsConstructor (access = PROTECTED)
@NoArgsConstructor (access = PROTECTED)
@Service
@Getter
@ToString
public class OrdersItem extends BaseEntity {

    @ManyToOne
    private Product product; //상품 (post 의 내용들)

    //주문
    @ManyToOne
    private Orders orders;

    //상품 가격
    public long getPayPrice() {
        return product.getPrice();
    }
    public void setPaymentDone() {
      switch (product.getRelTypeCode()){
          case "post" -> orders.getBuyer().addMyPost(product.getPost());
      }
    }

    public void setCancelDone() {
    }

    //환불 시 나의 수업에 저장 되어 있는 수업 제거
    public void setRefundDone() {
        switch (product.getRelTypeCode()){
            case "post" -> orders.getBuyer().removeMyPost(product.getPost());
        }
    }
}
