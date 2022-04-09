package com.exercise_bank.dto;

import com.exercise_bank.model.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SavingDto implements Validator {
    private Integer id;
    @NotEmpty(message = "ngày bắt đầu gửi không được để trống!!!")
    private String startTimeSave;
    @NotNull
    @Min(value = 1, message = "Kỳ hạn không được là số âm!!!")
    private Integer period;
    @NotNull
    @Min(value = 30000000, message = "Số tiền gửi tiết kiệm không được ít hơn 30 triệu!!!")
    private Long moneySave;

    private Customer customer;

    public SavingDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTimeSave() {
        return startTimeSave;
    }

    public void setStartTimeSave(String startTimeSave) {
        this.startTimeSave = startTimeSave;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Long getMoneySave() {
        return moneySave;
    }

    public void setMoneySave(Long moneySave) {
        this.moneySave = moneySave;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
