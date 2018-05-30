package com.javasampleapproach.apachekafka.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Entity
public class Bet {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private Integer amount;
    private Integer rows;


    public Bet() {
    }

    public Bet(User user, Integer amount, Integer rows) {
        this.user = user;
        this.amount = amount;
        this.rows = rows;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}

