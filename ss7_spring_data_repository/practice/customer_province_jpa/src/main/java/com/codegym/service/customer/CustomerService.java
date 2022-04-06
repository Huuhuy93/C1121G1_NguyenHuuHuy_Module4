package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository icustomerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return icustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return icustomerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        icustomerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        icustomerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return icustomerRepository.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return icustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable) {
        return icustomerRepository.findAllByFirstNameContaining(firstName, pageable);
    }
}
