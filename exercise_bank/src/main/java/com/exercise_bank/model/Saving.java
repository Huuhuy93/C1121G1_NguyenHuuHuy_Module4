package com.exercise_bank.model;

import javax.persistence.*;

@Entity
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "datetime")
    private String startTimeSave;
    private Integer period;
    private Long moneySave;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer")
    private Customer customer;

    public Saving() {
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
}
