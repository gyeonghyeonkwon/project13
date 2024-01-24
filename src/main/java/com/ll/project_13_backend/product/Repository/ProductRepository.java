package com.ll.project_13_backend.product.Repository;

import com.ll.project_13_backend.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Long> {


}
