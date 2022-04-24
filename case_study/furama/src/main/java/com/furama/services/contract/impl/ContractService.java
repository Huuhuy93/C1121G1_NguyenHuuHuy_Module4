package com.furama.services.contract.impl;

import com.furama.models.contract.Contract;
import com.furama.repository.contract.IContractRepository;
import com.furama.services.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public Contract findById(Integer id) {
        return iContractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        this.iContractRepository.save(contract);
    }

    @Override
    public void remove(int contractId) {
        this.iContractRepository.deleteById(contractId);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findAllByCustomer(String name, Pageable pageable) {
        return iContractRepository.findAllByCustomer(name, pageable);
    }
}
