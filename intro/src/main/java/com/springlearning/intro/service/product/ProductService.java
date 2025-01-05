package com.springlearning.intro.service.product;

import com.springlearning.intro.dto.ProductDTO;
import com.springlearning.intro.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Optional<Product> update(Long id, Product productDetails);
    boolean delete(Long id);
}
