package com.ll.project_13_backend.post.entity;

import com.ll.project_13_backend.global.BaseEntity;
import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String title; //제목

    private String content; //내용

    @Enumerated(EnumType.STRING)
    private Category category; //카테고리

    private long price; //가격

    @OneToOne
    private Product product; //상품


}
