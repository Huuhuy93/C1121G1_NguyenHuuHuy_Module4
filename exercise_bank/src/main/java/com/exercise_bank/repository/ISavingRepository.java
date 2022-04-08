package com.exercise_bank.repository;

import com.exercise_bank.model.Customer;
import com.exercise_bank.model.Saving;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISavingRepository extends JpaRepository<Saving, Integer> {
    Iterable<Saving> findAllByCustomer(Customer customer);
//    Page<Saving> findAllByNameCustomer(String name, Pageable pageable);
}
