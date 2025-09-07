package com.example.InsurenceRestapis5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity @Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String claimNumber;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private ClaimStatus status;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="policy_id")
    private Policy policy;


}
