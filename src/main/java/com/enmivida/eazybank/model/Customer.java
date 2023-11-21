package com.enmivida.eazybank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    // strategy is @Deprecated
    // @GenericGenerator(name = "native", strategy = "native")
    private Integer id;
    private String email;
    private String pwd;
    private String role;
}
