package com.exercise_bank.repository;

import com.exercise_bank.model.Customer;
import com.exercise_bank.model.Saving;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ISavingRepository extends JpaRepository<Saving, Integer> {
    Iterable<Saving> findAllByCustomer(Customer customer);
//    @Query(value = "select saving.*,customer.name_customer from saving\n" +
//            "join customer on saving.id_customer = customer.id_customer\n" +
//            "where customer.name_customer like concat('%',?1,'%') ",nativeQuery = true)
//    Page<Saving>findAllByNameCustomer( String nameCustomer, Pageable pageable);
}
