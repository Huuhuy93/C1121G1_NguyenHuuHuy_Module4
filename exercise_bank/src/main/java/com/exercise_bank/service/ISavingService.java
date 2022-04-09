package com.exercise_bank.service;

import com.exercise_bank.model.Customer;
import com.exercise_bank.model.Saving;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISavingService {
    public Iterable<Saving> findAll();

    public Saving findById(Integer id);

    public void save(Saving saving);

    public void remove(Integer id);

    Iterable<Saving> findAllByCustomer(Customer customer);

    Page<Saving> findAll(Pageable pageable);

    Page<Saving> findAllByNameCustomer(String nameCustomer, Pageable pageable);
}
