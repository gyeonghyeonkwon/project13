package com.ll.project_13_backend.member.entity;


import com.ll.project_13_backend.global.BaseEntity;
import com.ll.project_13_backend.post.entity.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Setter
@Getter
@ToString(callSuper = true)
public class MyPost extends BaseEntity {

    @ManyToOne
    private Member owner;

    @ManyToOne
    private Post post;
}
