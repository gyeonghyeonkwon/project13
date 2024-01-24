package com.ll.project_13_backend.post.service;

import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.post.entity.Category;
import com.ll.project_13_backend.post.entity.Post;
public interface PostService {


    Post createPost(Member member, String title, String content, Category category, long price);


}

