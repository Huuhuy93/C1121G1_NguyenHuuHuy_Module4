package com.furama.dto.contract_detail;

import com.furama.models.contract.Contract;
import com.furama.models.contract_detail.AttachService;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ContractDetailDto {
    private Integer contractDetailId;
    @NotNull
    @Min(value = 0)
    private Integer quantity;

    private Contract contract;
    private AttachService attachService;

    public ContractDetailDto() {
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
