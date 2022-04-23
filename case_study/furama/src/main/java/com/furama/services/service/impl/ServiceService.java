package com.furama.services.service.impl;

import com.furama.models.service.ServiceFurama;
import com.furama.repository.service.IServiceRepository;
import com.furama.services.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository iServiceRepository;

    @Override
    public List<ServiceFurama> findAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public ServiceFurama findById(Integer id) {
        return iServiceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ServiceFurama serviceFurama) {
        this.iServiceRepository.save(serviceFurama);
    }

    @Override
    public void remove(int serviceId) {
        this.iServiceRepository.deleteById(serviceId);
    }

    @Override
    public Page<ServiceFurama> findAll(Pageable pageable) {
        return iServiceRepository.findAll(pageable);
    }

    @Override
    public Page<ServiceFurama> findAllByServiceName(String name, Pageable pageable) {
        return iServiceRepository.findAllByServiceName(name, pageable);
    }
}
