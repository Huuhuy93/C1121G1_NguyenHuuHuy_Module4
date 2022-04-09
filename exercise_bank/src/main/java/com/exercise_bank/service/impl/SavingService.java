package com.exercise_bank.service.impl;

import com.exercise_bank.model.Customer;
import com.exercise_bank.model.Saving;
import com.exercise_bank.repository.ISavingRepository;
import com.exercise_bank.service.ISavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SavingService implements ISavingService {
    @Autowired
    ISavingRepository iSavingRepository;

    @Override
    public Iterable<Saving> findAll() {
        return iSavingRepository.findAll();
    }

    @Override
    public Saving findById(Integer id) {
        return iSavingRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Saving saving) {
        iSavingRepository.save(saving);
    }

    @Override
    public void remove(Integer id) {
        iSavingRepository.deleteById(id);
    }

    @Override
    public Iterable<Saving> findAllByCustomer(Customer customer) {
        return iSavingRepository.findAllByCustomer(customer);
    }

    @Override
    public Page<Saving> findAll(Pageable pageable) {
        return iSavingRepository.findAll(pageable);
    }

    @Override
    public Page<Saving> findAllByNameCustomer(String nameCustomer, Pageable pageable) {
        return iSavingRepository.findAllByNameCustomer(nameCustomer, pageable);
    }


}
