package com.furama.services.contract_detail.impl;

import com.furama.models.contract_detail.ContractDetail;
import com.furama.repository.contract_detail.IContractDetailRepository;
import com.furama.services.contract_detail.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(Integer id) {
        return iContractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        this.iContractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(int contractDetailId) {
        this.iContractDetailRepository.deleteById(contractDetailId);
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return iContractDetailRepository.findAll(pageable);
    }

//    @Override
//    public Page<ContractDetail> findAllByAttachService(String name, Pageable pageable) {
//        return iContractDetailRepository.findAllByAttachService(name, pageable);
//    }
}
