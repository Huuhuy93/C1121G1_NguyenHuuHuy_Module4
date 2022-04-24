package com.furama.repository.contract;

import com.furama.models.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from contract inner join customer on contract.customer_id = customer.customer_id where customer.customer_name like concat('%',:nameCustomer,'%')"
            , nativeQuery = true)
    Page<Contract> findAllByCustomer(@Param("nameCustomer") String nameCustomer, Pageable pageable);
}
