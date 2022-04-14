package com.customer_manager_restful.repository;

import com.customer_manager_restful.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
