package com.furama.services.customer;

import com.furama.models.customer.Customer;
import com.furama.repository.ICustomerUseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    public List<Customer> findAll();

    public Customer findById(Integer id);

    public void save(Customer customer);

    public void remove(int customerId);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByCodeAndNameAndPhoneContaining(String code, String name, String phone, Pageable pageable);

    Page<ICustomerUseService> findAllCustomerUseService(Pageable pageable);
}
