package com.add_product_cart.service;

import com.add_product_cart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);

}
