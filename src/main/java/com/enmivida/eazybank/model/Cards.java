package com.enmivida.eazybank.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Data
@Table(name = "cards")
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @Column(name = "card_id")
    private Integer cardId;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "total_limit")
    private Integer totalLimit;
    @Column(name = "amount_used")
    private Integer amountUsed;
    @Column(name = "available_amount")
    private Integer availableAmount;
    @Column(name = "create_dt")
    private Date createDt;
}