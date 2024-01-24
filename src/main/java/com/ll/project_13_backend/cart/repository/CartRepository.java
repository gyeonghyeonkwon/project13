package com.ll.project_13_backend.cart.repository;

import com.ll.project_13_backend.cart.entity.Cart;
import com.ll.project_13_backend.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByBuyer(Member buyer);

}
