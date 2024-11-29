package com.xyzbank.ms_account.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Getter
@Setter
@Entity
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(unique = true)
    private String account_number;
    private double balance=0.0;
//    private AccountType account_type;
    private String customer_id;

    public enum AccountType {       // Se crea el tipo de dato enum
        AHORROS, CORRIENTE
    }

    // Constructor por defecto
    public Account() {
    }

    // Constructor
    public Account(Long id, String account_number, double balance, String customer_id)
    {
        this.id = id;
        this.account_number = account_number;
        this.balance = balance;
        this.customer_id = customer_id;

    }
}
