package com.furama.services.contract_detail;

import com.furama.models.contract.Contract;
import com.furama.models.contract_detail.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    public List<ContractDetail> findAll();

    public ContractDetail findById(Integer id);

    public void save(ContractDetail contractDetail);

    public void remove(int contractDetailId);

    Page<ContractDetail> findAll(Pageable pageable);

//    Page<ContractDetail> findAllByAttachService(String name, Pageable pageable);
}
