package com.add_product_cart.service.impl;

import com.add_product_cart.model.Product;
import com.add_product_cart.repository.IProductRepository;
import com.add_product_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }
}
