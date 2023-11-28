package com.enmivida.eazybank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "accounts")
public class Accounts {
    @Column(name = "customer_id")
    private Integer customerId;
    @Id
    @Column(name = "account_number")
    private Integer accountNumber;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "branch_address")
    private String branchAddress;
    @Column(name = "create_dt")
    private Date createDt;
}

