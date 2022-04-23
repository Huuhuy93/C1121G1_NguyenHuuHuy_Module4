package com.furama.services.service;

import com.furama.models.customer.Customer;
import com.furama.models.service.ServiceFurama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    public List<ServiceFurama> findAll();

    public ServiceFurama findById(Integer id);

    public void save(ServiceFurama serviceFurama);

    public void remove(int serviceId);

    Page<ServiceFurama> findAll(Pageable pageable);

    Page<ServiceFurama> findAllByServiceName(String name, Pageable pageable);
}
