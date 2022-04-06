package com.service;

import com.model.Product;
import com.repositoy.IProductRepository;
import com.repositoy.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService {
    private IProductRepository iProductRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        iProductRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        iProductRepository.remove(id);
    }

    @Override
    public List<String> findNameProduct() {
        return iProductRepository.findNameProduct();
    }

    @Override
    public List<Product> search(String name) {
        return iProductRepository.search(name);
    }
}
