package com.furama.dto.contract;

import com.furama.models.customer.Customer;
import com.furama.models.employee.Employee;
import com.furama.models.service.ServiceFurama;

import javax.validation.constraints.NotBlank;

public class ContractDto {
    private int contractId;
    @NotBlank(message = "cannot blank !")
    private String contractStartDate;
    @NotBlank(message = "cannot blank !")
    private String contractEndDate;
    @NotBlank(message = "cannot blank !")
    private String contractDeposit;
    @NotBlank(message = "cannot blank !")
    private String contractTotalMoney;
    private Employee employee;
    private Customer customer;
    private ServiceFurama serviceFurama;

    public ContractDto() {
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public String getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(String contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ServiceFurama getServiceFurama() {
        return serviceFurama;
    }

    public void setServiceFurama(ServiceFurama serviceFurama) {
        this.serviceFurama = serviceFurama;
    }
}
