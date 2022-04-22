package com.furama.services.customer.impl;

import com.furama.models.customer.Customer;
import com.furama.repository.customer.ICustomerRepository;
import com.furama.services.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public void remove(int customerId) {
        this.iCustomerRepository.deleteById(customerId);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByCodeAndNameAndPhoneContaining(String code, String name, String phone, Pageable pageable) {
        return iCustomerRepository.findAllByCodeAndNameAndPhoneContaining(code, name, phone, pageable);
    }


}
