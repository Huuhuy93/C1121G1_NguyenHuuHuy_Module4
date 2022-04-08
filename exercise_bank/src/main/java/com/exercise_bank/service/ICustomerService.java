package com.exercise_bank.service;

import com.exercise_bank.model.Customer;
import com.exercise_bank.model.Saving;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    public Iterable<Customer> findAll();

    public Optional<Customer> findById(Integer id);

    public void save(Customer customer);

    public void remove(Integer id);

    Page<Customer> findAll(Pageable pageable);
}
