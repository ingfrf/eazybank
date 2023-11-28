package com.enmivida.eazybank.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Data
@Table(name = "notice_details")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @Column(name = "notice_id")
    private Integer noticeId;
    @Column(name = "notice_summary")
    private String noticeSummary;
    @Column(name = "notice_details")
    private String noticeDetails;
    @Column(name = "notic_beg_dt")
    private Date noticBegDt;
    @Column(name = "notic_end_dt")
    private Date noticEndDt;
    @Column(name = "create_dt")
    private Date createDt;
    @Column(name = "update_dt")
    private Date updateDt;
}
