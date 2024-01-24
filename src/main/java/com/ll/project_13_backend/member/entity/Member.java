package com.ll.project_13_backend.member.entity;

import com.ll.project_13_backend.global.BaseEntity;
import com.ll.project_13_backend.post.entity.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
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

    @OneToMany(mappedBy = "owner" , cascade = ALL , orphanRemoval = true)
    @Builder.Default
    private List<MyPost> myPosts = new ArrayList<>();
    // 나의 수업 저장
    public void addMyPost(Post post) {

        MyPost myPost = MyPost.builder()
                .owner(this)
                .post(post)
                .build();

        myPosts.add(myPost);
    }

    //환 불 시 나의 수업 이름이 post 면 삭제
    public void removeMyPost(Post post) {
        myPosts.removeIf(myPost -> myPost.getPost().equals(post));
    }
}
