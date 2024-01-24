package com.ll.project_13_backend.product.service;

import com.ll.project_13_backend.post.entity.Post;
import com.ll.project_13_backend.product.Repository.ProductRepository;
import com.ll.project_13_backend.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product createProduct(Post post) {

        if(post.getProduct() !=null) return  post.getProduct();

        Product product = Product.builder()
                .teacher(post.getMember())
                .relId(post.getId())
                .relTypeCode(post.getModelName()) //이름
                .name(post.getTitle())
                .price(post.getPrice())
                .build();
        productRepository.save(product);

        return product;
    }
}


