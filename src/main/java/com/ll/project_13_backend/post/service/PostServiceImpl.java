package com.ll.project_13_backend.post.service;

import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.post.entity.Category;
import com.ll.project_13_backend.post.entity.Post;
import com.ll.project_13_backend.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Transactional
    public Post createPost(Member member, String title, String content, Category category, BigDecimal price) {

      Post post = Post.builder()
              .member(member)
              .title(title)
              .content(content)
              .price(price)
              .category(category)
              .build();

        postRepository.save(post);

      return post;
    }
}