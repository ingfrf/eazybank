package com.enmivida.eazybank.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Data
@Table(name = "contact_messages")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @Column(name = "contact_id")
    private String contactId;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "contact_email")
    private String contactEmail;
    @Column(name = "subject")
    private String subject;
    @Column(name = "message")
    private String message;
    @Column(name = "create_dt")
    private Date createDt;
}

