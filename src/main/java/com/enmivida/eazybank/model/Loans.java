package com.enmivida.eazybank.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Data
@Table(name = "loans")
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @Column(name = "loan_number")
    private Integer loanNumber;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "start_dt")
    private Date startDt;
    @Column(name = "loan_type")
    private String loanType;
    @Column(name = "total_loan")
    private Integer totalLoan;
    @Column(name = "amount_paid")
    private Integer amountPaid;
    @Column(name = "outstanding_amount")
    private Integer outstandingAmount;
    @Column(name = "create_dt")
    private Date createDt;
}
