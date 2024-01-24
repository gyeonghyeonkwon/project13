package com.ll.project_13_backend.member.entity;

import com.ll.project_13_backend.global.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Setter
@Getter
@ToString(callSuper = true)
public class Member extends BaseEntity {

    private String username;
    private String password;

    private long restCash; //회원이 가지고 있는 캐쉬
}
