package com.furama.services.contract;

import com.furama.models.contract.Contract;
import com.furama.models.service.ServiceFurama;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    public List<Contract> findAll();

    public Contract findById(Integer id);

    public void save(Contract contract);

    public void remove(int contractId);

    Page<Contract> findAll(Pageable pageable);

    Page<Contract> findAllByCustomer(String name, Pageable pageable);
}
