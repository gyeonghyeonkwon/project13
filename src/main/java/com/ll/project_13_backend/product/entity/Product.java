package com.ll.project_13_backend.product.entity;

import com.ll.project_13_backend.global.BaseEntity;
import com.ll.project_13_backend.member.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Getter
@Setter
@ToString(callSuper = true)
public class Product extends BaseEntity {

    @ManyToOne
    private Member teacher; //강사

    private String name; //이름

    private long price; //상품 가격

    private String relTypeCode;  //Post

    private long relId;




}
