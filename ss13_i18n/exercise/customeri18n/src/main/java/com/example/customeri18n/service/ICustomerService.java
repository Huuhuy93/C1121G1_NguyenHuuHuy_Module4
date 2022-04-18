package com.example.customeri18n.service;

import com.example.customeri18n.model.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> findAll();
    public void save(Customer customer);
}
