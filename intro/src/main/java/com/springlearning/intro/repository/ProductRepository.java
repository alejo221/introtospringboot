package com.springlearning.intro.repository;

import com.springlearning.intro.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
