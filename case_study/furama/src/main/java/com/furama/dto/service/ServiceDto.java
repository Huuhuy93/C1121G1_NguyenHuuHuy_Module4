package com.furama.dto.service;

import com.furama.models.service.RentType;
import com.furama.models.service.ServiceType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ServiceDto {
    private Integer serviceId;

    @NotBlank(message = "The name service cannot blank !")
    private String serviceName;

    @NotNull(message = "The Area service cannot blank !")
    @Min(value = 0, message = "Area must be positive numbers !")
    private Integer serviceArea;

    @NotNull(message = "The cost service cannot blank !")
    @Min(value = 0, message = "Cost must be positive numbers !")
    private Double serviceCost;

    @NotNull(message = "The max people service cannot blank !")
    @Min(value = 0, message = "People must be positive numbers !")
    private Integer serviceMaxPeople;

    @NotBlank(message = "The standard room cannot blank !")
    private String standardRoom;
    @NotBlank(message = "cannot blank !")
    private String descriptionOtherConvenience;

    @Min(value = 0, message = "The pool must be positive numbers !")
    private Double poolArea;

    @Min(value = 0, message = "The number of floors must be positive numbers !")
    private Integer numberOfFloors;

    private RentType rentType;
    private ServiceType serviceType;

    public ServiceDto() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
