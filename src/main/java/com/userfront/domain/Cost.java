package com.userfront.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private String description;
    private String type;
    private double amount;

    public Cost() {}


    public Cost(Date date, String description, String type, double amount, Account account) {
        this.date = date;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.account = account;
    }

    @ManyToOne
    @JoinColumn(name = "primary_account_id")
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
