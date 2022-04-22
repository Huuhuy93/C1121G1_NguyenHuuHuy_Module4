package com.furama.services.customer;

import com.furama.models.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    public List<CustomerType> findAll();
}
